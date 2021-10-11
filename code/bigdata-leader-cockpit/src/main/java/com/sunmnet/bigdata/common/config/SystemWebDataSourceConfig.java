package com.sunmnet.bigdata.common.config;

import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.common.constants.ApplicationConstants;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by summer on 2016/11/25.
 */
@Configuration
@MapperScan(basePackages = "com.sunmnet.bigdata.web.mapper", sqlSessionTemplateRef  = "systemWebSqlSessionTemplate")
public class SystemWebDataSourceConfig {

	@Autowired
	private Environment env;
	@Autowired
	private ApplicationContext ctx;

    @Bean(name = "systemWebDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.systemWeb")
    public DataSource systemWebDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "systemWebSqlSessionFactory")
    public SqlSessionFactory systemWebSqlSessionFactory(@Qualifier("systemWebDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		// Mybatis Mapper XML Config
		Resource[] resourceArray = ctx.getResources("classpath:/mybatis/mappers/statis/**/*.xml");
		sessionFactory.setMapperLocations(resourceArray);

		sessionFactory.setVfs(SpringBootVFS.class);
		sessionFactory.setTypeAliasesPackage(env.getProperty(ApplicationConstants.STATIS_ALIASES_PACKAGE));

		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		// Mybatis Plugins
		Interceptor[] plugins = new Interceptor[]{
				(Interceptor) ctx.getBean("sqlLogInterceptor"),pageHelper
		};
		sessionFactory.setPlugins(plugins);
		return sessionFactory.getObject();
    }

    @Bean(name = "systemWebTransactionManager")
    public DataSourceTransactionManager systemWebTransactionManager(@Qualifier("systemWebDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "systemWebSqlSessionTemplate")
    public SqlSessionTemplate systemWebSqlSessionTemplate(@Qualifier("systemWebSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
