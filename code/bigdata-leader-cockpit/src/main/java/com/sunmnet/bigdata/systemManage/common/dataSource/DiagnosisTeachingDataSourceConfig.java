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
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * Created by summer on 2016/11/25.
// */
//@Configuration
//@MapperScan(basePackages = "com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching", sqlSessionTemplateRef  = "diagnosisTeachingSqlSessionTemplate")
//public class DiagnosisTeachingDataSourceConfig {
//
//    @Bean(name = "diagnosisTeachingDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.diagnosisTeaching")
//    @Primary
//    public DataSource diagnosisTeachingDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "diagnosisTeachingSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory diagnosisTeachingSqlSessionFactory(@Qualifier("diagnosisTeachingDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/diagnosisTeaching/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "diagnosisTeachingTransactionManager")
//    @Primary
//    public DataSourceTransactionManager diagnosisTeachingTransactionManager(@Qualifier("diagnosisTeachingDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "diagnosisTeachingSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate diagnosisTeachingSqlSessionTemplate(@Qualifier("diagnosisTeachingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
