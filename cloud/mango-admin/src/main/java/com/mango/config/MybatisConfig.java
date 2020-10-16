package com.mango.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Mybatis配置
 */
@Configuration
@MapperScan("com.mango.dao")    // 扫描DAO
public class MybatisConfig {

  @Autowired
  private DataSource dataSource;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setTypeAliasesPackage("com.mango.model");    // 扫描Model

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    //这里不能是mapper文件夹免得扫描到其它的JAR的目录
//    sessionFactory.setMapperLocations(resolver.getResources("classpath*: **/sysmap/*.xml"));    // 扫描映射文件
    sessionFactory.setMapperLocations(resolver.getResources("classpath:mapping/*Mapper.xml"));    // 扫描映射文件

    return sessionFactory.getObject();
  }
}