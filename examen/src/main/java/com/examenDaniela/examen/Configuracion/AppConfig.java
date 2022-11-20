package com.examenDaniela.examen.Configuracion;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/**
 * @author Daniela Carolina Silva Laguna.
 */
@Configuration
public class AppConfig {
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        /*dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sqlserver");*/
        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=PRUEBA;trustServerCertificate=true");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("Danny283");
        return dataSourceBuilder.build();
    }
}
