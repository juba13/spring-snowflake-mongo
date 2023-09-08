///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pridesys.census.configuration;
//
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
///**
// *
// * @author mdshahadat.sarker
// */
//@Configuration
//public class DbConfig {
//    
//    @Bean(name = "msCensusDB")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.census")
//    public DataSource mysqlHealthRohingyaDataSource() {
//            return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "mysqlCensusJdbcTemplate")
//    public JdbcTemplate mysqlWebJdbcTemplate(@Qualifier("msCensusDB") DataSource dsCustomMySQL) {
//            return new JdbcTemplate(dsCustomMySQL);
//    }
//    
//    @Bean(name = "namedCensusJdbcTemplate")
//    public NamedParameterJdbcTemplate namedSchJdbcTemplate(@Qualifier("msCensusDB") DataSource dsCustomMySQL) {
//            return new NamedParameterJdbcTemplate(dsCustomMySQL);
//    }
//}
//
