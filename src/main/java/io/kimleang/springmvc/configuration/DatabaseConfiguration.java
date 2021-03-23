package io.kimleang.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("org.postgresql.Driver");
        db.setUrl("jdbc:postgresql://localhost:5432/spring_mvc");
        db.setUsername("postgres");
        db.setPassword("1234");
        return db;
    }

}
