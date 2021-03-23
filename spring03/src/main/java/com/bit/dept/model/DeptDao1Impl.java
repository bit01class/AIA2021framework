package com.bit.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao1Impl implements DeptDao {
	DataSource dataSource;
	DataSource dataSource2;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDataSource2(DataSource dataSource2) {
		this.dataSource2 = dataSource2;
	}

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno desc";
		List<DeptVo> list=new ArrayList<DeptVo>();
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

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void insertTwo(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		Connection conn2=null;
		PreparedStatement pstmt2=null;
		try{
			conn=dataSource.getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			pstmt.executeUpdate();
			conn2=dataSource2.getConnection();
			conn2.setAutoCommit(false);
			pstmt2=conn2.prepareStatement(sql);
			pstmt2.setInt(1, bean.getDeptno());
			pstmt2.setString(2, bean.getDname());
			pstmt2.setString(3, bean.getLoc());
			pstmt2.executeUpdate();
			conn.commit();
			conn2.commit();
		}catch(SQLException e) {
			if(conn!=null)conn.rollback();
			if(conn2!=null)conn2.rollback();
		}finally {
			if(conn!=null)conn.setAutoCommit(true);
			if(conn2!=null)conn2.setAutoCommit(true);
			if(conn!=null)conn.close();
			if(conn2!=null)conn2.close();
		}
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
