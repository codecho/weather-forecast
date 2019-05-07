package com.youngpain.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Author pain
 * @Date 2018/11/7 17:23
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    //使用Druid数据源
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

}
