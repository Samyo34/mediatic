package fr.dta.globale;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Conf {
	
	@Autowired
	private Environment env;
	
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/temp");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("hibernate.driverClassName"));
		ds.setUrl(env.getRequiredProperty("hibernate.url"));
		ds.setUsername(env.getRequiredProperty("hibernate.username"));
		ds.setPassword(env.getRequiredProperty("hibernate.password"));
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "fr.dta" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(additionalProperties());
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		source.setBasename("classpath:label");
//		return source;
//	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.use_second_level_cache", env.getRequiredProperty("hibernate.use_second_level_cache"));
		return properties;
	}
}
