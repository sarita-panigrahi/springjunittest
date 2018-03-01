package org.sdrc.boot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

@Configuration
public class AppConfig  {

	@Bean
	public MessageDigestPasswordEncoder passwordEncoder() {
		// implements MessageDigestPasswordEncoder and override encode method
		// with the MD5 protocol
		return new Md5PasswordEncoder();
	}

/*	@Bean
	public ResourceBundleMessageSource configpropsMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages/configprops");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}*/
	 
	/*When using a persistence framework such as Hibernate, 
	native exceptions thrown within classes annotated with @Repository will be automatically translated into subclasses of Spring’s DataAccessExeption*/
	public @Bean PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	}
}
 