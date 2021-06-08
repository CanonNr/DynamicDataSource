package com.example.dds.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Primary
    @Bean(name = "MasterDataSource")
    public DataSource getMasterDataSource() {
        DataSourceBuilder<?> ds = DataSourceBuilder.create();
        ds.url("jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        ds.driverClassName("com.mysql.cj.jdbc.Driver");
        ds.username("test1");
        ds.password("123456");
        ds.type(com.alibaba.druid.pool.DruidDataSource.class);
        return ds.build();
    }


    @Bean(name = "SlaveDataSource")
    public DataSource getSlaveDataSource() {
        DataSourceBuilder<?> ds = DataSourceBuilder.create();
        ds.url("jdbc:mysql://127.0.0.1:3306/test2?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        ds.driverClassName("com.mysql.cj.jdbc.Driver");
        ds.username("test2");
        ds.password("123456");
        ds.type(com.alibaba.druid.pool.DruidDataSource.class);
        return ds.build();
    }


    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("MasterDataSource") DataSource MasterDataSource,
                                        @Qualifier("SlaveDataSource") DataSource SlaveDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.MASTER, MasterDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.SLAVE, SlaveDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
//        dataSource.setDefaultTargetDataSource(SlaveDataSource);
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }
}
