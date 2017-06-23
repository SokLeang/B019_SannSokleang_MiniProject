package com.hrd.leang.configuration;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
@MapperScan("com.hrd.leang.repository")
public class MyBatisConfiguartion {
	
	private DataSource datasource;
	@Autowired
	public MyBatisConfiguartion(DataSource datasource) {
		this.datasource=datasource;
	}
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(datasource);
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		return sessionFactoryBean;
	}
	
}
