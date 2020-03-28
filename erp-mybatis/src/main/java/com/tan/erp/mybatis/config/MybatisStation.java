package com.tan.erp.mybatis.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @Author: nieyy
 * @Date: 2020/3/3 22:43
 * @Version 1.0
 * @Description:
 */

@Configuration
@EnableTransactionManagement
public class MybatisStation {

    @Autowired
    @Qualifier("dataSource2")
    private DataSource dataSource2;

    @Value("${mybatis.configuration.map-underscore-to-camel-case}")
    private boolean underscore;

    @Value("${mybatis.configuration.call-setters-on-nulls}")
    private boolean setters;

    @Value("${mybatis.configuration.cache-enabled}")
    private boolean cache;

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        /** 设置mybatis configuration 扫描路径 */
        //sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        /** 设置datasource */
        sqlSessionFactoryBean.setDataSource(dataSource2);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //使用jdbc的getGeneratedKeys获取数据库自增主键值
        configuration.setUseGeneratedKeys(true);
        //-自动使用驼峰命名属性映射字段
        configuration.setMapUnderscoreToCamelCase(underscore);
        configuration.setCallSettersOnNulls(setters);
        configuration.setCacheEnabled(cache);

        sqlSessionFactoryBean.setConfiguration(configuration);

        /** 设置typeAlias 包扫描路径 */
        //sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionStation")
    public SqlSession sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


//    @Bean("annotationDrivenTransactionManager2")
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource2);
//    }


}
