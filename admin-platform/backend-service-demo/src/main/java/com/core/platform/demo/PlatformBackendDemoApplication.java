package com.core.platform.demo;//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.core.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 * 测试案例 启动类
 * @EnableAsync 开启异步调用 使用配置文件修改常量
 * @author daixu
 * @date 2021-06-23
 */
@EnableAsync
@EnableCustomSwagger2
@SpringBootApplication
@EnableFeignClients//(defaultConfiguration = FeignConfiguration.class)
public class PlatformBackendDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatformBackendDemoApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  案例模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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

