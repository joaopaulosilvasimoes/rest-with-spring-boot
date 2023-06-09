package br.com.joao.simoes.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.joao.simoes.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	public static final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.add(new YamlJackson2HttpMessageConverter());
		
	}

	//QueryParam
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//
//		configurer.
//		favorParameter(true).
//		parameterName("mediaType").
//		ignoreAcceptHeader(true).
//		useRegisteredExtensionsOnly(false).
//		defaultContentType(MediaType.APPLICATION_JSON).
//		mediaType("json", MediaType.APPLICATION_JSON).
//		mediaType("xml", MediaType.APPLICATION_XML);
//		
//	}
	
	//HEADER PARAM
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		configurer.
		favorParameter(false).
		ignoreAcceptHeader(false).
		useRegisteredExtensionsOnly(false).
		defaultContentType(MediaType.APPLICATION_JSON).
		mediaType("json", MediaType.APPLICATION_JSON).
		mediaType("xml", MediaType.APPLICATION_XML).
		mediaType("x_yaml", MEDIA_TYPE_APPLICATION_YAML);
		
	}

}
