package com.bit.sts12;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

@SpringBootApplication
@MapperScan(basePackages = {"com.bit.sts12.model"})
public class Sts12Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts12Application.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(
									SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
	
	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager tx=null;
		tx= new DataSourceTransactionManager(dataSource);
		return tx;
	}
}










