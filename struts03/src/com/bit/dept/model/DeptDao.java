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
	Logger log=Logger.getLogger(this.getClass().getName());
	DataSource dataSource;
	
	public DeptDao() throws SQLException {
		OracleDataSource source=new OracleDataSource();
		source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		source.setUser("scott");
		source.setPassword("tiger");
		dataSource=source;
	}
	
	public List<DeptVo> selectAll() throws SQLException{
		String sql="select * from dept order by deptno";	
		List<DeptVo> list=new ArrayList<>();
		try(	
	Connection conn=dataSource.getConnection();
	PreparedStatement pstmt=conn.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next()) {
				list.add(new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						));
				log.info(list.get(list.size()-1).toString());
			}
		}
		return list;
	}
	
	public void insertOne(int deptno,String dname,String loc) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		try(
		Connection conn=dataSource.getConnection();		
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
		}
	}
	
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
		pstmt.setInt(1, deptno);
		ResultSet rs=pstmt.executeQuery();	
		if(rs.next())
			return new DeptVo(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		rs.close();
		}
		return null;
	}
	
	public int updateOne(int deptno,String dname,String loc) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			return pstmt.executeUpdate();
		}
	}
}










