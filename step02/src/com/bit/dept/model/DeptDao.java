package com.bit.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.bit.dept.model.entity.DeptVo;

import oracle.jdbc.pool.OracleDataSource;

public class DeptDao {
	Logger log=Logger.getGlobal();
	DataSource dataSource;
	
	public DeptDao() {
		try {
			OracleDataSource source = new OracleDataSource();
			source.setDriverType("oracle.jdbc.OracleDriver");
			source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			source.setUser("scott");
			source.setPassword("tiger");
			dataSource=source;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List getList() {
		String sql="select * from dept";
		List list=new ArrayList();
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptVo bean=new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
				log.info(bean.toString());
				log.warning(bean.toString());
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insertOne(DeptVo deptVo) {
		String sql="insert into dept values (?,?,?)";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptVo.getDeptno());
			pstmt.setString(2, deptVo.getDname());
			pstmt.setString(3, deptVo.getLoc());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}









