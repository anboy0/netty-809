package com.unicom.netty809.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Desc: mybatis-plus 配置
 * @author:zhengs
 * @Time: 18-12-29 上午9:20
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
@Configuration
@MapperScan("com.unicom.netty809.mapper*")
public class MybatisPlusConfig {

    @Autowired
	DruidDataSource druidDataSource;

    /**
     * 逻辑删除全局值（默认0，标示未删除）
     */
    private static final String logicDeleteValue="0";

    /**
     * 逻辑删除全局值（默认1，标示未删除）
     */
    private static final String logicNotDeleteValue="1";

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);
        paginationInterceptor.setDialectType("mysql"); 
        
        return paginationInterceptor;
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 动态数据源配置
     * @return
     */
    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() throws Exception {
    	return druidDataSource.getDataSource();
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }


    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        sqlSessionFactory.setPlugins(new Interceptor[]{paginationInterceptor()});
        sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue(logicDeleteValue);
        conf.setLogicNotDeleteValue(logicNotDeleteValue);
        conf.setIdType(IdType.NONE.getKey());
        conf.setDbColumnUnderline(true);
        conf.setRefresh(true);
//        conf.setMetaObjectHandler(new MyMetaObjectHandler());
        return conf;
    }
}