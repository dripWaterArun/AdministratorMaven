package com.core.cloud.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关 gateway 启动类
 * @author daixu
 * @date 2022-05-19
 */
@SpringBootApplication
public class SystemCloudServiceGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemCloudServiceGatewayApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Gateway 网关模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "  _________ __                 __      _________                                          _____     .__  .__         \n" +
                " /   _____//  |______ ________/  |_   /   _____/__ __   ____  ____  ____   ______ _______/ ____\\_ __|  | |  | ___.__.\n" +
                " \\_____  \\\\   __\\__  \\\\_  __ \\   __\\  \\_____  \\|  |  \\_/ ___\\/ ___\\/ __ \\ /  ___//  ___/\\   __\\  |  \\  | |  |<   |  |\n" +
                " /        \\|  |  / __ \\|  | \\/|  |    /        \\  |  /\\  \\__\\  \\__\\  ___/ \\___ \\ \\___ \\  |  | |  |  /  |_|  |_\\___  |\n" +
                "/_______  /|__| (____  /__|   |__|   /_______  /____/  \\___  >___  >___  >____  >____  > |__| |____/|____/____/ ____|\n" +
                "        \\/           \\/                      \\/            \\/    \\/    \\/     \\/     \\/                       \\/"
        );
    }
}

