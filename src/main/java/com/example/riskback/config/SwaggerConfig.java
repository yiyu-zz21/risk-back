package com.example.riskback.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2 )
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo( apiInfo() )
                // 设置哪些接口暴露给Swagger展示
                .select()
                // (第一种方式)扫描所有有注解的api，用这种方式更灵活
                .apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class ) )
                // (第二种方式)扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.zxc.springtest001.controller"))
                // (第三种方式)扫描所有
                //.apis(RequestHandlerSelectors.any())
                .paths( PathSelectors.any() )
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title( "标题：应用API文档" )
                // 描述
                .description( "描述：向前端提供应用的ResultFul风格接口文档" )
                // 作者信息
                .contact( "zhx" )
                // 版本
                .version( "版本号:" + "V1.0.0" )
                .build();
    }
//    /**
//     * 解决swagger-ui.html 404无法访问的问题
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 解决静态资源无法访问
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//        // 解决swagger无法访问
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        // 解决swagger的js文件无法访问
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
