//package com.sunmnet.bigdata.common.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import com.sunmnet.bigdata.common.constants.ApplicationConstants;
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
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.github.pagehelper.PageHelper;
//
///**
// * 大数据Web系统前端数据源配置类
// */
//@SpringBootConfiguration
//@PropertySource("classpath:application.properties")
//@MapperScan(basePackages = "com.sunmnet.bigdata.systemManage.dao.*", sqlSessionFactoryRef = "manageSqlSessionFactory")
//public class AdminDatasourceConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Autowired
//    private ApplicationContext ctx;
//
//    @Bean(name="manageDataSource")
//    public DataSource manageDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//
//        // 基本属性
//        dataSource.setDriverClassName(env.getProperty("systemManage.jdbc.driverClass"));
//        dataSource.setUrl(env.getProperty("systemManage.jdbc.jdbcUrl"));
//        dataSource.setUsername(env.getProperty("systemManage.jdbc.username"));
//        dataSource.setPassword(env.getProperty("systemManage.jdbc.password"));
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
//    @Bean(name="manageSqlSessionFactory")
//    public SqlSessionFactory manageSqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(manageDataSource());
//
//        // Mybatis Config
//        Configuration configuration = new Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        sessionFactory.setConfiguration(configuration);
//
//        // Mybatis Mapper XML Config
//        Resource[] resourceArray = ctx.getResources("classpath:/mybatis/mappers/system/**/*.xml");
//        sessionFactory.setMapperLocations(resourceArray);
//
//		sessionFactory.setVfs(SpringBootVFS.class);
//		sessionFactory.setTypeAliasesPackage(env.getProperty(ApplicationConstants.SYSTEM_ALIASES_PACKAGE));
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
//            (Interceptor) ctx.getBean("sqlLogInterceptor"),pageHelper
//        };
//        sessionFactory.setPlugins(plugins);
//
//        return sessionFactory.getObject();
//    }
//
//	@Bean(name="manageTransactionManager")
//	public PlatformTransactionManager manageTransactionManager() {
//	    return new DataSourceTransactionManager(manageDataSource());
//	}
//
//	@Bean(name = "manageSqlSessionTemplate")
//	public SqlSessionTemplate systemManageSqlSessionTemplate(@Qualifier("manageSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//}
