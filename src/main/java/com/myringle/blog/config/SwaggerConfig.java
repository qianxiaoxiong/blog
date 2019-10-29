package com.myringle.blog.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    // 接口版本号
    private final String version = "1.0";
    // 接口大标题
    private final String title = "myblog项目";
    // 具体的描述
    private final String description = "API文档自动生成示例";
    // 服务说明url
    private final String termsOfServiceUrl = "http://www.myringle.com";
//    // licence
//    private final String license = "MIT";
    // licnce url
//    private final String licenseUrl = "https://mit-license.org/";

    // 接口作者联系方式

    private final Contact contact = new Contact("钱小熊", "https://github.com/qianxiaoxiong", "1139452801@qq.com ");

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf())
                .select()
                // 不显示错误的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title(title).termsOfServiceUrl(termsOfServiceUrl).description(description)
                .version(version).contact(contact).build();

    }


}