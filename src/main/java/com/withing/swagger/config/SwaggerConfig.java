package com.withing.swagger.config;

import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;

/**
 * @author huangweixin1@jd.com
 * create 2018/12/6 13:55
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    //    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()//build模式,返回一个建造者
                .apis(RequestHandlerSelectors.any())//api的配置路径
                .paths(PathSelectors.any())//扫描路径选择
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title") //文档标题
                .description("这是一个示例接口")//接口概述
                .version("1.0") //版本号
                .termsOfServiceUrl(String.format("url"))//服务的域名
                .license("LICENSE")//证书
                .licenseUrl("http://www.123.com")//证书的url
                .build();
    }

}
