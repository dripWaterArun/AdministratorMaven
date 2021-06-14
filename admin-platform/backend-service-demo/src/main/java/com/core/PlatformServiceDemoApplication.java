package com.core;//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 测试案例 启动类
 * @EnableAsync 开启异步调用 使用配置文件修改常量
 */
@EnableAsync
//@EnableSwagger2
@SpringBootApplication
@EnableFeignClients//(defaultConfiguration = FeignConfiguration.class)
public class PlatformServiceDemoApplication {
    public static void main(String[] args) {
        //AutoProperties.init();//通过反射加载配置文件中的内容,赋值给常量
        SpringApplication.run(PlatformServiceDemoApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文曦启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
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

