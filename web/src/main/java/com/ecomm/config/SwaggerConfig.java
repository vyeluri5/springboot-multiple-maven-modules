package com.ecomm.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	/**
	 *  Full list of annotations
	 * 	https://github.com/swagger-api/swagger-core/wiki/annotations
	 */

	private static final Contact DEFAULT_CONTACT = new Contact("vyeluri5","https://www.linkedin.com/in/vyeluri5/","@");

	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		"eCommerce API Documentation",
		"API service documentation for all functions in eCommerce API",
			"1.0",
			"urn:tos",
			DEFAULT_CONTACT,
			"Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0"
	);

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
			new HashSet<>(Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
