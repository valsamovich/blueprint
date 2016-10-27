package com.samovich.service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.cxf.jaxrs.spring.SpringComponentScanServer;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

/**
 * Spring Boot App configuration.
 * Filename App.java
 * Created by Valery Samovich
 * Written on 7/14/16
 */

@EnableScheduling
@SpringBootApplication
@Import({SpringComponentScanServer.class, JmxAutoConfiguration.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * Defines the servlet bean to use with CXF.
     *
     * @return the {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/*");
    }

    /**
     * @param objectMapper - the configured object mapper to use for the JAX-RS
     *                     Provider
     * @return a provider to use for JAX-RS data-binding
     */
    @Bean
    public JacksonJsonProvider jsonMapperProvider(ObjectMapper objectMapper) {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(objectMapper);
        return provider;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new AfterburnerModule());
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://HOST:PORT/DATABASE_NAME");
        dataSource.setUsername("DB_USER");
        dataSource.setPassword("RB_PW");
        dataSource.setValidationQuery("select 1");
        dataSource.setMaxTotal(50);
        dataSource.setTestOnBorrow(true);
        dataSource.setMaxWaitMillis(10000);
        dataSource.setRemoveAbandonedOnBorrow(true);
        dataSource.setDefaultAutoCommit(false);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }

}