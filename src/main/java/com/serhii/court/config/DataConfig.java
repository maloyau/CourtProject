package com.serhii.court.config;

import com.serhii.court.entity.User;
import com.serhii.court.service.impl.AuditorAwareServiceImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableJpaRepositories(basePackages = "com.serhii.court.repository")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = {"com.serhii.court"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class DataConfig {

    @Value("${spring.datasource.DriverClassName}")
    private String DATASOURCE_DRIVER_CLASS_NAME;
    @Value("${spring.datasource.Url}")
    private String DATASOURCE_URL;
    @Value("${spring.datasource.Username}")
    private String DATASOURCE_USERNAME;
    @Value("${spring.datasource.Password}")
    private String DATASOURCE_PASSWORD;
    @Value("${hibernate.DatabasePlatform}")
    private String HIBERNATE_DATABASE_PLATFORM;
    @Value("${hibernate.GenerateDdl}")
    private boolean HIBERNATE_GENERATE_DDL;
    @Value("${hibernate.ShowSql}")
    private boolean HIBERNATE_SHOW_SQL;
    @Value("${hibernate.PackagesToScan}")
    private String HIBERNATE_PACKAGES_TO_SCAN;
    @Value("${hikari.MaximumPoolSize}")
    private int HIKARI_MAX_POOL_SIZE;
    @Value("${hikari.CachePrepStmts}")
    private String HIKARI_CACHE_PREP_STMTS;
    @Value("${hikari.PrepStmtCacheSize}")
    private String HIKARI_PREP_STMTS_CACHE_SIZE;
    @Value("${hikari.PrepStmtCacheSqlLimit}")
    private String HIKARI_PREP_STMTS_CACHE_SQL_LIMIT;

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
        hikariConfig.setJdbcUrl(DATASOURCE_URL);
        hikariConfig.setUsername(DATASOURCE_USERNAME);
        hikariConfig.setPassword(DATASOURCE_PASSWORD);
        hikariConfig.setMaximumPoolSize(HIKARI_MAX_POOL_SIZE);
        hikariConfig.addDataSourceProperty("cachePrepStmts", HIKARI_CACHE_PREP_STMTS);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize" , HIKARI_PREP_STMTS_CACHE_SIZE);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", HIKARI_PREP_STMTS_CACHE_SQL_LIMIT);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public HibernateJpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(HIBERNATE_DATABASE_PLATFORM);
        vendorAdapter.setGenerateDdl(HIBERNATE_GENERATE_DDL);
        vendorAdapter.setShowSql(HIBERNATE_SHOW_SQL);
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter());
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(HIBERNATE_PACKAGES_TO_SCAN);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareServiceImpl();
    }

}
