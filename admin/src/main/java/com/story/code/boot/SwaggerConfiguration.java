/*
package com.story.code.boot;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/
/**
 * swagger2接口文档配置
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 *//*

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket petApi() {
        final ApiInfo apiInfo = new ApiInfo("rest API接口文档", "desc", "v0.0.1", null, new Contact("", "", "'"), "license", "licenseUrl", Lists.newArrayList());
        return new Docket(DocumentationType.SWAGGER_2)
            .forCodeGeneration(true)
            .apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("")
            .directModelSubstitute(LocalDate.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
            .useDefaultResponseMessages(false)
            ;
    }
}
*/
