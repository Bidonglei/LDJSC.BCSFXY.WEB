package com.sunmnet.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 1.应用主配置类，@SpringBootApplication和同时使用@Configuration、@EnableAutoConfiguration、@ComponentScan效果相同。
 *
 * 2.@ComponentScan将会自动扫描所有以@Repository、@Service、@Component等注解标注的Spring组件，其中也包括@Configuration，
 *   所以，若应用中需要引入其他配置，只需添加相关的以@Configuration注解标注的配置类即可。
 *
 * 3.SpringApplication会自动从application.properties文件加载应用配置，并将各个配置项放入
 *   {@link org.springframework.core.env.Environment Environment}，加载顺序如下：
 *     a). 该配置类所在目录的/config子目录
 *     b). 该配置类所在目录
 *     c). classpath中/config目录
 *     d). classpath根目录
 *   其他组件中若需要使用配置项，可通过@Autowire引入Environment即可：
 *   <pre class="code">
 *   &#064;Configuration
 *   &#064;PropertySource("classpath:/com/myco/app.properties")
 *   public class AppConfig {
 *     &#064;Autowired
 *     Environment env;
 *
 *     &#064;Bean
 *     public TestBean testBean() {
 *         TestBean testBean = new TestBean();
 *         testBean.setName(env.getProperty("testbean.name"));
 *         return testBean;
 *     }
 *   }</pre>
 *
 * 4.Spring-Boot默认支持多个日志系统，具体使用哪个取决于classpath中相应日志jar包和配置文件：
 *   Logback：logback-spring.xml，logback-spring.groovy，logback.xml 或 logback.groovy
 *   Log4j2：log4j2-spring.xml 或 log4j2.xml
 *   JDK (Java Util Logging)：logging.properties
 *
 * 5.启动可通过spring-boot Maven插件启动：clean install spring-boot:run -Pdev
 */
@SpringBootConfiguration
//@ComponentScan(basePackages = {"com.sunmnet.bigdata.common.config"})
@SpringBootApplication
@EnableTransactionManagement
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableWebMvc
public class BigdataLeaderCockpitApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BigdataLeaderCockpitApplication.class, args);
    }

	//设置session失效时间
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);//单位为S
			}
		};
	}
}
