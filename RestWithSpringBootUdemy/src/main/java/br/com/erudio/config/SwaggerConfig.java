package br.com.erudio.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Edilson
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * http://localhost:8080/v2/api-docs
	 * ou
	 * http://localhost:8080/swagger-ui.html
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.erudio"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RestFul API With SpringBoot 2.1.3", 
				"Descrição sobre a API", 
				"V1", 
				"Termos de Serviço", 
				new Contact("Edilson", "http://urlexample", "edilsonbsfilho@gmail.com"), 
				"Termos de Licença", 
				"Temos de URL", 
				Collections.emptyList());
	}
}
