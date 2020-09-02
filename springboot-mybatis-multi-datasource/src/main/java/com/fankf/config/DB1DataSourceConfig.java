package com.fankf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * fankunfeng
 * 2020-09-02 09:44
 */
@Configuration
@MapperScan(basePackages = DB1DataSourceConfig.PACKAGE,sqlSessionFactoryRef = "dB1DataSourceConfig")
public class DB1DataSourceConfig {

    public static final String PACKAGE ="com.fankf.dao.db1";
    public static final String MAPPER_LOCATION ="classpath:mapper/db1/*.xml";

    @Value("${db1.datasource.url}")
    private String url;

    @Value("${db1.datasource.username}")
    private String user;

    @Value("${db1.datasource.password}")
    private String password;

    @Value("${db1.datasource.driver-class-name}")
    private String driverClass;

    //数据源
    @Bean("db1DataSource")
    public DataSource db1DataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 事务
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager db1TransactionManager() {
        return new DataSourceTransactionManager(db1DataSource());
    }


    //工厂类
    @Bean("dB1DataSourceConfig")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DB1DataSourceConfig.MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
