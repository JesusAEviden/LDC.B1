package com.gestor.eventos.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.gestor.eventos")  // Asegúrate de que el paquete sea correcto
@EnableJpaRepositories(basePackages = "com.gestor.eventos.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

    // Propiedades de la base de datos MariaDB
    private String dbUrl = "jdbc:mariadb://localhost:3306/OrganizadorEventos";
    private String dbUsername = "root"; 
    private String dbPassword = "123456";
    private String dbDriver = "org.mariadb.jdbc.Driver";

    // Configuración del pool de conexiones utilizando HikariCP
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbUrl); 
        hikariConfig.setUsername(dbUsername);
        hikariConfig.setPassword(dbPassword);
        hikariConfig.setDriverClassName(dbDriver);

        return new HikariDataSource(hikariConfig);
    }

    // Configuración de EntityManagerFactory (para JPA)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.gestor.eventos.model");  // El paquete donde están tus entidades
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        // Configuración para crear las tablas automáticamente al iniciar la aplicación
        factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");  // 'update' para actualizar la DB automáticamente con las entidades
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");  // Dialecto adecuado para MariaDB

        return factoryBean;
    }

    // Configuración de PlatformTransactionManager (para manejar transacciones)
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
