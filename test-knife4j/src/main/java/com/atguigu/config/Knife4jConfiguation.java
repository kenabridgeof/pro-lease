package com.atguigu.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: Knife4jConfiguation
 * Package: com.atguigu.config
 */
@Configuration
public class Knife4jConfiguation {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("hello-knife4j项目API")
						.version("1.0")
						.description("hello-knife4j项目的接口文档"));
	}

	@Bean
	public GroupedOpenApi userAPI() {
		return GroupedOpenApi.builder().group("用户信息管理").
				pathsToMatch("/user/**").
				build();
	}

	@Bean
	public GroupedOpenApi systemAPI() {
		return GroupedOpenApi.builder().group("产品信息管理").
				pathsToMatch("/product/**").
				build();
	}
}
