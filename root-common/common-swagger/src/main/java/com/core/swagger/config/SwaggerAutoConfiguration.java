package com.core.swagger.config;

//import cn.weiguangfu.swagger2.plus.annotation.EnableSwagger2Plus;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.ant;

/**
 * swagger网址:http://localhost:9089/swagger-ui.html#/
 * swagger2的配置文件，在项目的启动类的同级文件建立
 * @author daixu
 * @date 2021-06-28
 */
// @EnableKnife4j
@Configuration
//@EnableSwagger2Plus
@EnableSwagger2
@EnableAutoConfiguration
@ConditionalOnProperty(name = "configs.swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    /*引入Knife4j提供的扩展类*/
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerAutoConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @author daixu
     * @date 2021-06-28
     */
    @Bean
    public Docket createRestApi() {
        String groupName="2.X版本";
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.OAS_30)
                // 是否启用Swagger 可以读取配置文件 swaggerProperties.getEnabled()
                .enable(swaggerProperties().getEnabled())
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                .select()
                // 扫描所有
                .paths(PathSelectors.any())
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 设置哪些接口暴露给Swagger展示
//                .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
                .build().globalOperationParameters(pars)
                //赋予插件体系
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
    }

    /**
     * 自定义摘要信息
     * @author daixu
     * @date 2021-06-28
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 页面标题
                .title(swaggerProperties().getTitle())
                // 创建人信息
                .contact(new Contact(swaggerProperties().getAuthor(), "http:/test-url.com", swaggerProperties().getEmail()))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                // 版本号
                .version(swaggerProperties().getVersion())
                // 描述信息
                .description(swaggerProperties().getDescription())
                .build();
    }
}
