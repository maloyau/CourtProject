package com.serhii.court.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.serhii.court.data.repository")
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
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


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
        dataSource.setUrl(DATASOURCE_URL);
        dataSource.setUsername(DATASOURCE_USERNAME);
        dataSource.setPassword(DATASOURCE_PASSWORD);
        return dataSource;
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
}
