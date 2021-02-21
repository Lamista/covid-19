package com.laurastasiule.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laurastasiule.app.domain.CountryWeeklyData;
import com.laurastasiule.app.service.CountryWeeklyDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class App extends SpringBootServletInitializer {

	private static String DATA_URL = "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.laurastasiule.app"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("REST Documentation").version("0.0.1-SNAPSHOT").build();
	}

	@Bean
	CommandLineRunner runner(CountryWeeklyDataService service) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountryWeeklyData>> typeReference = new TypeReference<>() {};

			try(InputStream inputStream = new java.net.URL(DATA_URL).openStream()) {
				List<CountryWeeklyData> allData = mapper.readValue(inputStream, typeReference);
				service.save(allData);
				System.out.println("-----------------------------Data saved!-------------------------------");
			} catch (IOException e) {
				System.out.println(
						"--------------------------------Unable to save data: "
						+ e.getMessage()
						+ "------------------------------------");
			}
		};
	}
}
