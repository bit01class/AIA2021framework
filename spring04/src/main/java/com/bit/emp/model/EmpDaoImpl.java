package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bit.emp.model.entity.EmpVo;

public class EmpDaoImpl implements EmpDao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
	private RowMapper<EmpVo> rowMapper=new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno")
					,rs.getInt("pay")
					,rs.getInt("deptno")
					,rs.getString("ename")
					,rs.getDate("nalja")
					);
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Override
	public List<EmpVo> selectAll() {
		String sql="select * from emp order by empno";
		PreparedStatementCreator psc=null;
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				return pstmt;
			}
		};
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public EmpVo selectOne(int empno) {
		String sql="select * from emp where empno=?";
		PreparedStatementCreator psc=null;
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, empno);
				return pstmt;
			}
		};
		return jdbcTemplate.query(psc, rowMapper).get(0);
	}

	@Override
	public void insertOne(EmpVo bean) {
		String sql="insert into emp values (?,?,now(),?,?)";
		PreparedStatementCreator psc=null;

		TransactionStatus status=null;
		TransactionDefinition definition=null;
		definition=new DefaultTransactionDefinition();
		
		status=transactionManager.getTransaction(definition);
		try {
		//첫번째
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bean.getEmpno());
				pstmt.setString(2, bean.getEname());
				pstmt.setInt(3, bean.getPay());
				pstmt.setInt(4, bean.getDeptno());
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
		//두번째
		psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bean.getEmpno()+1);
				pstmt.setString(2, bean.getEname());
				pstmt.setInt(3, bean.getPay());
				pstmt.setInt(4, bean.getDeptno()+1);
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
		
		transactionManager.commit(status);
		}catch(Exception e) {
			transactionManager.rollback(status);
		}
		
	}

	@Override
	public int updateOne(EmpVo bean) {
		return 0;
	}

	@Override
	public int deleteOne(int empno) {
		return 0;
	}

}
