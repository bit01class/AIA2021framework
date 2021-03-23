package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.entity.DeptVo;

public class DeptDao01 implements DeptDao {
	Connection conn;

	public DeptDao01() {
		String driver="org.mariadb.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/xe";
		String user="scott";
		String password="tiger";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<DeptVo> selectAll(){
		String sql="select * from dept";
		List<DeptVo> list=new ArrayList<>();
		try(
		Connection conn=this.conn;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();	
				){
			while(rs.next())
				list.add(new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						));
		} catch (SQLException e) {
					e.printStackTrace();
				}
		return list;
	}
	
	public void insertOne(DeptVo bean) {
		String sql="insert into dept values (?,?,?)";
		try(
		Connection conn=this.conn;
		PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, bean.getDeptno());
			pstmt.setString(2, bean.getDname());
			pstmt.setString(3, bean.getLoc());
			pstmt.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	}

	@Override
	public DeptVo selectOne(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOne(DeptVo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int deptno) {
		// TODO Auto-generated method stub
		return 0;
	}
}









