//package com.sunmnet.bigdata.common.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.github.pagehelper.PageHelper;
//import com.sunmnet.bigdata.common.constants.ApplicationConstants;
//
///**
// * 大数据Web统计数据源配置类
// */
//@SpringBootConfiguration
//@PropertySource("classpath:application.properties")
//@MapperScan(basePackages = "com.sunmnet.bigdata.web.mapper", sqlSessionFactoryRef = "statisSqlSessionFactory")
//public class StatisDatasourceConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Autowired
//    private ApplicationContext ctx;
//
//    @Bean(name="statisDataSource")
//    @Primary
//    public DataSource statisDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//
//        // 基本属性
//        dataSource.setDriverClassName(env.getProperty("statis.jdbc.driverClass"));
//        dataSource.setUrl(env.getProperty("statis.jdbc.jdbcUrl"));
//        dataSource.setUsername(env.getProperty("statis.jdbc.username"));
//        dataSource.setPassword(env.getProperty("statis.jdbc.password"));
//
//        // 配置初始化大小、最小、最大
//        dataSource.setInitialSize(1);
//        dataSource.setMinIdle(1);
//        dataSource.setMaxActive(20);
//
//        // 配置获取连接等待超时的时间，单位是毫秒
//        dataSource.setMaxWait(60000);
//
//        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
//        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//
//        // 配置一个连接在池中最小生存的时间，单位是毫秒
//        dataSource.setMinEvictableIdleTimeMillis(300000);
//
//        // 配置连接存活测试
//        dataSource.setValidationQuery("select 1");
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTestOnBorrow(true);
//        dataSource.setTestOnReturn(true);
//
//        dataSource.setPoolPreparedStatements(false);
//        return dataSource;
//    }
//
//    @Bean(name="statisSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory statisSqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(statisDataSource());
//
//        // Mybatis Config
//        Configuration configuration = new Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        sessionFactory.setConfiguration(configuration);
//
//        // Mybatis Mapper XML Config
//        Resource[] resourceArray = ctx.getResources("classpath:/mybatis/mappers/statis/**/*.xml");
//        sessionFactory.setMapperLocations(resourceArray);
//
//        sessionFactory.setVfs(SpringBootVFS.class);
//        sessionFactory.setTypeAliasesPackage(env.getProperty(ApplicationConstants.STATIS_ALIASES_PACKAGE));
//
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//        // Mybatis Plugins
//        Interceptor[] plugins = new Interceptor[]{
//                (Interceptor) ctx.getBean("sqlLogInterceptor"),pageHelper
//        };
//        sessionFactory.setPlugins(plugins);
//
//        return sessionFactory.getObject();
//    }
//
//    @Bean(name="statisTransactionManager")
//	public PlatformTransactionManager statisTransactionManager() {
//	    return new DataSourceTransactionManager(statisDataSource());
//	}
//
//	@Bean(name = "statisSqlSessionTemplate")
//	public SqlSessionTemplate systemManageSqlSessionTemplate(@Qualifier("statisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//}
