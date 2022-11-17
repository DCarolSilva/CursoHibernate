package com.daniela.prueba.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {
    @Value("${usr}")
    private String usuario;
    @Value("${pass}")
    private String password;
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        //dataSourceBuilder.username("sa");
      //  dataSourceBuilder.password("sqlserver");
        dataSourceBuilder.username(usuario);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
