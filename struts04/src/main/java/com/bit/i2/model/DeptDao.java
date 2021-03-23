package com.bit.i2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import com.bit.i2.model.entity.DeptVo;

public class DeptDao {
	static DataSource dataSource;
	
	public DeptDao() throws SQLException {
		if(dataSource==null) {
		MariaDbDataSource source=new MariaDbDataSource();
		source.setUrl("jdbc:mysql://localhost:3306/xe");
		source.setUser("scott");
		source.setPassword("tiger");
		dataSource=source;
		}
	}

	public List<DeptVo> selectAll() throws SQLException{
		String sql="select * from dept order by deptno";
		List<DeptVo> list=new ArrayList<>();
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						));
		}
		return list;
	}
	
	public DeptVo selectOne(int key) throws SQLException {
		String sql="select * from dept where deptno=?";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, key);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return new DeptVo(
					rs.getInt("deptno")
					,rs.getString("dname")
					,rs.getString("loc")
					);
		}
		return null;
	}
	
	public int insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int key) throws SQLException{
		String sql="delete from dept where deptno=?";
		try(
		Connection conn=dataSource.getConnection();	
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, key);
			return pstmt.executeUpdate();
		}
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getDname());
			pstmt.setString(2, bean.getLoc());
			pstmt.setInt(3, bean.getDeptno());
			return pstmt.executeUpdate();
		}
	}
}




















