package com.ecomm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;
import java.util.Properties;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ecomm.web", "com.ecomm.config", "com.ecomm.domain", "com.ecomm.exceptions", "com.ecomm.services" })
@EnableJpaRepositories(basePackages = { "com.ecomm.domain", "com.ecomm.models" })
@EntityScan(basePackages = { "com.ecomm.models" })
public class WebApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);

		return  localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");

		return messageSource;
	}

//	@Bean
//	public EmbeddedDatabase dataSource()
//	{
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		builder.setType(H2)
//				.setScriptEncoding("UTF-8")
//				.addScript("classpath:data.sql");
//
//		return builder.build();
//	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
//	{
//		LocalContainerEntityManagerFactoryBean emanager = new LocalContainerEntityManagerFactoryBean();
//		emanager.setDataSource(dataSource());
//		emanager.setPackagesToScan(new String [] { "com.ecomm.web", "com.ecomm.domain", "com.ecomm.services" });
//
//		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		emanager.setJpaVendorAdapter(jpaVendorAdapter);
//		emanager.setJpaProperties(additionalProp());
//
//		return emanager;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
//	{
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(emf);
//
//		return transactionManager;
//	}
//
//	Properties additionalProp()
//	{
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//		return properties;
//	}
}
