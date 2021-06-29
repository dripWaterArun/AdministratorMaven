package com.core.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger 读取 yaml 配置
 * @author daixu
 * @date 2021-06-28
 */
@Data
@Component
@ConfigurationProperties("configs.swagger")
public class SwaggerProperties {
    /**
     * 标题
     **/
    private String title;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 作者
     */
    private String author;

    /**
     * 版本
     */
    private String version;

    /**
     * 是否开启 swagger（生产环境关闭 swagger）
     */
    private Boolean enabled;

    /**
     * 描述
     */
    private String description;
}
