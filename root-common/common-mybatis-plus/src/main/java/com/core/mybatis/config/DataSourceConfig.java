package com.core.mybatis.config;

import com.core.datasource.config.DruidConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据源配置
 * @author daixu
 * @date 2021-06-28
 */
//@Configuration
public class DataSourceConfig {

//    @Resource
//    private DruidConfiguration dataSourceConfig;
//
//    @Bean(name="dataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource(){
//        return dataSourceConfig.druidDataSource();
//    }
//
//    /**
//     * 配置事物管理器
//     */
//    @Bean(name="transactionManager")
//    public DataSourceTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource());
//    }
}
