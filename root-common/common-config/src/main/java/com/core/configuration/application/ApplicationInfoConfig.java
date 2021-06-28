package com.core.configuration.application;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * configuration 配置：
 * 将配置文件中配置的每一个属性值，映射到对应的属性中
 * @author daixu
 * @date 2021-06-28
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ApplicationInfoConfig {

    /** 项目名称 */
    private String name;

    /** 电子邮箱 */
    private String email;

    /** 作者 */
    private String author;

    /** 版本 */
    private String version;

    /** 版权年份 */
    private String copyrightYear;

    /** 实例演示开关 */
    private boolean demoEnabled;
}
