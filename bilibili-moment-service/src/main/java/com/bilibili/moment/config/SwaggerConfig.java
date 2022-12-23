package com.bilibili.moment.config;


import com.bilibili.common.config.CommonSwaggerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration // 标明是配置类
@EnableSwagger2 //开启swagger功能
//@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Value("${app.swagger.enable}")
    boolean enable;

    @Bean
    public Docket createRestApi() {
        return CommonSwaggerConfig.buildDocket(enable,apiInfo()
               );
    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User service api") //  可以用来自定义API的主标题
                .description("User api") // 可以用来描述整体的API
                .termsOfServiceUrl("") // 用于定义服务的域名
                .version("1.0") // 可以用来定义版本。
                .build(); //
    }

    private  List<Parameter> getParmeterList(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> parameters=new ArrayList<>();
        tokenPar.name("token").description("User token");
        parameters.add(tokenPar.build());
        return  parameters;
    }
}
