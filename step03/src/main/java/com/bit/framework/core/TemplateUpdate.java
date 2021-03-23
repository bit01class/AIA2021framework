package com.bit.framework.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TemplateUpdate {
	DataSource dataSource;
	Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	private PreparedStatement setPstmt(
			PreparedStatement pstmt,Object[] obj) 
					throws SQLException {
		for(int i=0; i<obj.length; i++)
			pstmt.setObject(i+1, obj[i]);
		return pstmt;
	}
	
	public int executeUpdate(String sql,Object[] obj) throws SQLException {
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt=setPstmt(pstmt,obj);
			return pstmt.executeUpdate();
		}finally {
			close();
		}
	}
	
	private void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}
