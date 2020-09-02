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
@MapperScan(basePackages = DB2DataSourceConfig.PACKAGE,sqlSessionFactoryRef = "db2DataSourceConfig")
public class DB2DataSourceConfig {

    public static final String PACKAGE ="com.fankf.dao.db2";
    public static final String MAPPER_LOCATION ="classpath:mapper/db2/*.xml";

    @Value("${db2.datasource.url}")
    private String url;

    @Value("${db2.datasource.username}")
    private String user;

    @Value("${db2.datasource.password}")
    private String password;

    @Value("${db2.datasource.driver-class-name}")
    private String driverClass;

    //数据源
    @Bean("db2DataSource")
    public DataSource db2DataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 事务
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager db2TransactionManager() {
        return new DataSourceTransactionManager(db2DataSource());
    }


    //工厂类
    @Bean("db2DataSourceConfig")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DB2DataSourceConfig.MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
