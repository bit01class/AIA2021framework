package com.bit.dept.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import com.bit.dept.model.entity.DeptVo;
import com.bit.framework.core.TemplateUpdate;

public class DeptDao {
	Logger log=Logger.getLogger("com.bit.dept.model.DeptDao");
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/xe";
	String user="scott";
	String password="tiger";
	Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSource;
	
	public DeptDao() throws SQLException {
		MariaDbDataSource source=new MariaDbDataSource();
		source.setDatabaseName(driver);
		source.setUrl(url);
		source.setUser(user);
		source.setPassword(password);
		dataSource=source;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public List selectAll() throws SQLException {
		String sql="select * from dept order by deptno";
		List list=new ArrayList();
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			///
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptVo bean=new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
				log.info(bean.toString());
				list.add(bean);
			}
		}finally {
			close();
		}
		return list;
	}
	
	public int insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		Object[] params= {bean.getDeptno(),bean.getDname(),bean.getLoc()};
		TemplateUpdate template=new TemplateUpdate();
		template.setDataSource(dataSource);
		return template.executeUpdate(sql,params);
	}
	
	public int deleteOne(int key) throws SQLException {
		String sql="delete from dept where deptno=?";
		Object[] params= {key};
		TemplateUpdate template=new TemplateUpdate();
		template.setDataSource(dataSource);
		return template.executeUpdate(sql,params);
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		Object[] params= {bean.getDname(),bean.getLoc(),bean.getDeptno()};
		TemplateUpdate template=new TemplateUpdate();
		template.setDataSource(dataSource);
		return template.executeUpdate(sql, params);
	}
	
	
	private void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}











