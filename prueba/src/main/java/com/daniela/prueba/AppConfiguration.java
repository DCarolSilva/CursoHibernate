package com.daniela.prueba;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sqlserver");
        return dataSourceBuilder.build();
    }
}
