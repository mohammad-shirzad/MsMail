package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"model", "config", "dao", "serviceImpl", "service"})
@PropertySource("classpath:database.properties")
@EnableJpaRepositories(basePackages = "dao", entityManagerFactoryRef = "emf")
public class DbAccessConfig {

    @Resource
    private org.springframework.core.env.Environment env;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));

        return dataSource;
    }

    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hibernateProp.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProp.put("hibernate.format_sql",
                env.getProperty("hibernate.format_sql"));
        return hibernateProp;
    }
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        try {
//            factoryBean.setDataSource(getDataSource());
//            factoryBean.setPackagesToScan("model", "config");
//            factoryBean.setHibernateProperties(getHibernateProperties());
//            factoryBean.afterPropertiesSet();
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return factoryBean;
//    }


//    @Bean
//    @Autowired
//    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }
}
