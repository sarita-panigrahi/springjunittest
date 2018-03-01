package org.sdrc.boot.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages/configprops.properties")
@ConfigurationProperties(prefix = "login")
public class ConfigProperties {

	private String userPrincipal;
	private String invalidCredentials;
	private String validCredentials;
	private String unauthorized;

	public String getUserPrincipal() {
		return userPrincipal;
	}

	public void setUserPrincipal(String userPrincipal) {
		this.userPrincipal = userPrincipal;
	}

	public String getInvalidCredentials() {
		return invalidCredentials;
	}

	public void setInvalidCredentials(String invalidCredentials) {
		this.invalidCredentials = invalidCredentials;
	}

	public String getValidCredentials() {
		return validCredentials;
	}

	public void setValidCredentials(String validCredentials) {
		this.validCredentials = validCredentials;
	}

	public String getUnauthorized() {
		return unauthorized;
	}

	public void setUnauthorized(String unauthorized) {
		this.unauthorized = unauthorized;
	}


}
