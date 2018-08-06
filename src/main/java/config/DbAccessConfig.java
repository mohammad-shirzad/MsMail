package config;

import model.dto.PersonDto;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"model","config"})
@PropertySource("classpath:database.properties")
public class DbAccessConfig {

    @Autowired
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

    @Bean
    public SessionFactory getSessionFactory() {
        LocalSessionFactoryBuilder sessionFactoryBean=new LocalSessionFactoryBuilder(getDataSource());

        try {
        sessionFactoryBean.scanPackages("model");
        sessionFactoryBean.addProperties(getHibernateProperties());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return sessionFactoryBean.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hibernateProp.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProp.put("hibernate.format_sql",
                env.getProperty("hibernate.format_sql"));
        return hibernateProp;
    }
}
