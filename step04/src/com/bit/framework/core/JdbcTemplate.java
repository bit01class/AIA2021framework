package com.bit.framework.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.framework.RowMapper;

public class JdbcTemplate<T> {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<T> queryForList(String sql,RowMapper<T> rowMapper) throws SQLException{
		Object[] obj= {};
		return queryForList(sql,rowMapper,obj);
	}

	public List<T> queryForList(String sql,RowMapper<T> rowMapper,Object ... obj) throws SQLException{
		List<T> list=new ArrayList<T>();
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0; i<obj.length; i++)
				pstmt.setObject(i+1, obj[i]);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
		}finally {
			close();
		}
		return list;
	}
	
	public T queryForOne(String sql,RowMapper<T> rowMapper,Object ... obj) throws SQLException{
		return queryForList(sql,rowMapper,obj).get(0);
	}
	
	public int executeUpdate(String sql,Object ... obj) throws SQLException {
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<obj.length; i++)
				pstmt.setObject(i+1, obj[i]);
			return pstmt.executeUpdate();
		}finally {close();}
	}
	
	public void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}
