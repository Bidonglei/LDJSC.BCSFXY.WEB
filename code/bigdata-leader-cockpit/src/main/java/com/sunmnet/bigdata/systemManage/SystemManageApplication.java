//package com.sunmnet.bigdata.systemManage;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@SpringBootApplication
//@EnableAsync
//@EnableCaching
//@EnableTransactionManagement
//@EnableWebMvc
//@EnableScheduling
//public class SystemManageApplication {
//    public static void main(String[] args) {
//		SpringApplication.run(SystemManageApplication.class, args);
//	}
//
//    //设置session失效时间
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setSessionTimeout(1800);//单位为S
//            }
//        };
//    }
//}
//