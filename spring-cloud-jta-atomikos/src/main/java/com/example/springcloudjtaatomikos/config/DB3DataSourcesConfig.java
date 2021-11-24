package com.example.springcloudjtaatomikos.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Classname: DB3DataSourcesConfig
 * @Description: TODO
 * @Date: 2021/11/23 16:21
 * @author: wwf
 */
@Configuration
@MapperScan(basePackages = "com.example.springcloudjtaatomikos.mapper.db3", sqlSessionFactoryRef = "db3SqlSessionFactory")
public class DB3DataSourcesConfig {

    @Bean(name = "db3DataSource")
    public DataSource dataSource(DB3Config db3Config) {

        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(db3Config.getUrl_jdbc());
        druidXADataSource.setUsername(db3Config.getUsername());
        druidXADataSource.setPassword(db3Config.getPassword());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("db3DataSource");

        return atomikosDataSourceBean;
    }

    @Bean(name = "db3SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db3DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/db3/*.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);

        sessionFactoryBean.setConfiguration(configuration);
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db3SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("db3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
