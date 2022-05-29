package com.core.datasource.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * druid连接池配置
 *
 * @author daixu
 * @date 2021-06-28
 */
@RefreshScope
@Configuration
public class DruidConfiguration {

  /**
   * 连接地址
   */
  @Value("${spring.datasource.url}")
  private String url;

  /**
   * 数据库账号
   */
  @Value("${spring.datasource.username}")
  private String username;

  /**
   * 数据库密码
   */
  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  /**
   * 初始化连接大小
   */
  @Value("${spring.druid.initialSize}")
  private int initialSize;

  /**
   * 最小连接池数量
   */
  @Value("${spring.druid.minIdle}")
  private int minIdle;

  /**
   * 最大连接池数量
   */
  @Value("${spring.druid.maxActive}")
  private int maxActive;

  /**
   * 获取连接时最大等待时间，单位毫秒
   */
  @Value("${spring.druid.maxWait}")
  private int maxWait;

  /**
   * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
   */
  @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
  private int timeBetweenEvictionRunsMillis;

  /**
   * 配置一个连接在池中最小生存的时间，单位是毫秒
   */
  @Value("${spring.druid.minEvictableIdleTimeMillis}")
  private int minEvictableIdleTimeMillis;

  /**
   * 测试连接
   */
  @Value("${spring.druid.validationQuery}")
  private String validationQuery;

  /**
   * 申请连接的时候检测，建议配置为true，不影响性能，并且保证安全性
   */
  @Value("${spring.druid.testWhileIdle}")
  private boolean testWhileIdle;

  /**
   * 获取连接时执行检测，建议关闭，影响性能
   */
  @Value("${spring.druid.testOnBorrow}")
  private boolean testOnBorrow;

  /**
   * 归还连接时执行检测，建议关闭，影响性能
   */
  @Value("${spring.druid.testOnReturn}")
  private boolean testOnReturn;

  @Value("${spring.druid.poolPreparedStatements}")
  private boolean poolPreparedStatements;

  /**
   * 是否开启PSCache，PSCache对支持游标的数据库性能提升巨大，oracle建议开启，mysql下建议关闭
   */
  @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
  private int maxPoolPreparedStatementPerConnectionSize;

  /**
   * 配置扩展插件，常用的插件有=>stat:监控统计  log4j:日志  wall:防御sql注入
   */
  @Value("${spring.druid.filters}")
  private String filters;

  /**
   * 通过connectProperties属性来打开mergeSql功能;慢SQL记录
   */
  @Value("{spring.druid.connectionProperties}")
  private String connectionProperties;

  @Bean
  @RefreshScope
  public DruidDataSource druidDataSource() {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(url);
    datasource.setUsername(username);
    // 这里可以做加密处理
    datasource.setPassword(password);
    datasource.setDriverClassName(driverClassName);

    // configuration
    datasource.setInitialSize(initialSize);
    datasource.setMinIdle(minIdle);
    datasource.setMaxActive(maxActive);
    datasource.setMaxWait(maxWait);
    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    datasource.setValidationQuery(validationQuery);
    datasource.setValidationQuery("SELECT 1");
    datasource.setTestWhileIdle(testWhileIdle);
    datasource.setTestOnBorrow(testOnBorrow);
    datasource.setTestOnReturn(testOnReturn);
    datasource.setPoolPreparedStatements(poolPreparedStatements);
    datasource.setMaxPoolPreparedStatementPerConnectionSize(
        maxPoolPreparedStatementPerConnectionSize);
    try {
      datasource.setFilters(filters);
    } catch (SQLException e) {

    }
    datasource.setConnectionProperties(connectionProperties);

    return datasource;
  }

//  @Bean
//  public ServletRegistrationBean statViewServlet() {
//    ServletRegistrationBean servletRegistrationBean =
//        new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//    // 设置ip白名单
//    //servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//    // 设置ip黑名单，优先级高于白名单
//    // servletRegistrationBean.addInitParameter("deny", "192.168.1.1");
//    // 设置控制台管理用户
//    servletRegistrationBean.addInitParameter("loginUsername", "root");
//    servletRegistrationBean.addInitParameter("loginPassword", "root");
//    // 是否可以重置数据
//    servletRegistrationBean.addInitParameter("resetEnable", "false");
//    return servletRegistrationBean;
//  }
//
//  @Bean
//  public FilterRegistrationBean statFilter() {
//    // 创建过滤器
//    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//    // 设置过滤器过滤路径
//    filterRegistrationBean.addUrlPatterns("/*");
//    // 忽略过滤的形式
//    filterRegistrationBean.addInitParameter(
//        "exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//    return filterRegistrationBean;
//  }
}
