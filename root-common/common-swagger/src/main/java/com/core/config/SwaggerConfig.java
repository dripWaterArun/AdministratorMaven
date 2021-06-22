package com.core.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static springfox.documentation.builders.PathSelectors.ant;

/**
 * swagger网址:http://localhost:9010/swagger-ui.html#/
 * swagger2的配置文件，在项目的启动类的同级文件建立
 * @author daixu
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @author daixu
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                // 是否启用Swagger 可以读取配置文件
                .enable(true)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                .securitySchemes(asList(
                        new OAuth(
                                "petstore_auth",
                                asList(new AuthorizationScope("write_pets", "modify pets in your account"),
                                        new AuthorizationScope("read_pets", "read your pets")),
                                Arrays.<GrantType>asList(new ImplicitGrant(new LoginEndpoint("http://petstore.swagger.io/api/oauth/dialog"), "tokenName"))
                        ),
                        new ApiKey("api_key", "api_key", "header")
                ))
                // 设置哪些接口暴露给Swagger展示
                .select()
                .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);


        /* 设置安全模式，swagger可以设置访问token */
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
//                .pathMapping(pathMapping);


//                .apiInfo(apiInfo())
//                .select()
//                // 为当前包路径
//                .apis(RequestHandlerSelectors.basePackage("com.ryxt")).paths(PathSelectors.any())
//                .build();


    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @return
     * @author daixu
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("标题：管理系统_接口文档")
                // 创建人信息
                .contact(new Contact("TestName", "http:/test-url.com", "test@test.de"))
                //.contact(new Contact("MrZhang",  "https://www.cnblogs.com/zs-notes/category/1258467.html",  "1729497919@qq.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }

    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<ApiKey> securitySchemes()
    {
        List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts()
    {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    /**
     * 默认的安全上引用
     */
    private List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}
