//package com.sunmnet.bigdata.systemManage.common.dataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * Created by summer on 2016/11/25.
// */
//@Configuration
//@MapperScan(basePackages = "com.sunmnet.bigdata.systemManage.dao.systemManage", sqlSessionTemplateRef  = "systemManageSqlSessionTemplate")
//public class SystemManageDataSourceConfig {
//
//    @Bean(name = "systemManageDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.systemManage")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "systemManageSqlSessionFactory")
//    public SqlSessionFactory systemManageSqlSessionFactory(@Qualifier("systemManageDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/systemManage/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "systemManageTransactionManager")
//    public DataSourceTransactionManager systemManageTransactionManager(@Qualifier("systemManageDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "systemManageSqlSessionTemplate")
//    public SqlSessionTemplate systemManageSqlSessionTemplate(@Qualifier("systemManageSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
