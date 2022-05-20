package com.core.api.sso;//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.core.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 * 单点登录 微服务
 * @author daixu
 * @date 2021-06-29
 */
@EnableAsync
@EnableFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class ApiServiceSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiServiceSSOApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  单点登录模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "  _________ __                 __      _________                                          _____     .__  .__         \n" +
                " /   _____//  |______ ________/  |_   /   _____/__ __   ____  ____  ____   ______ _______/ ____\\_ __|  | |  | ___.__.\n" +
                " \\_____  \\\\   __\\__  \\\\_  __ \\   __\\  \\_____  \\|  |  \\_/ ___\\/ ___\\/ __ \\ /  ___//  ___/\\   __\\  |  \\  | |  |<   |  |\n" +
                " /        \\|  |  / __ \\|  | \\/|  |    /        \\  |  /\\  \\__\\  \\__\\  ___/ \\___ \\ \\___ \\  |  | |  |  /  |_|  |_\\___  |\n" +
                "/_______  /|__| (____  /__|   |__|   /_______  /____/  \\___  >___  >___  >____  >____  > |__| |____/|____/____/ ____|\n" +
                "        \\/           \\/                      \\/            \\/    \\/    \\/     \\/     \\/                       \\/"
        );
    }

    /**
     * 在 spring容器中创建一个对象，类型 RestTemplate
     * 名称/ID (方法名)
     * 类似于传统的springMVC中 xml 文件的配置
     * <bean id="restTemplate" class="xx.RestTemplate"></>
     *
     * @LoadBalanced 负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

