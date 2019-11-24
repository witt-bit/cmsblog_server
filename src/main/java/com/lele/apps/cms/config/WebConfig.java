package com.lele.apps.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	/**
	 * 将自定义的token拦截器作为bean对象写入到配置中
	 * @return
	 */
	@Bean
	public JwtInterceptor jwtInterceptor(){
		return new JwtInterceptor();
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(3600);
	}
	
	/**
	 * 添加需要拦截的路径的方法
	 * @param registry
	 */
	
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		// 拦截路径可配置多个，用','隔开
		registry.addInterceptor(jwtInterceptor())
//				.addPathPatterns("/category/**","/article/**","/user/**","/role/**","/privilege/**")
				//拦截的资源
				.addPathPatterns("/**")
				// 排除不拦截的资源
				.excludePathPatterns(
						"/swagger-resources/**","/v2/**","/swagger-ui.html","/webjars/**",
						"/user/login","/user/logout","/article/download","/privilege/findPrivilegeTree"
				);
	
	}
}
