package com.grace.config.autoconfig;


import com.grace.config.ConditionalMyOnClass;
import com.grace.config.EnableMyConfigurationProperties;
import com.grace.config.MyAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    DataSource hikariDataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource.class) // DataSource 타입 빈이 딱하나만 등록 되어 있다면 가져와서 사용하겠다
    @ConditionalOnMissingBean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource.class)
    @ConditionalOnMissingBean
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }


}
