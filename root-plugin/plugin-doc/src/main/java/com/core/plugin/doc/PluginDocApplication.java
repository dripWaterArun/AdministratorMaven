package com.core.plugin.doc;//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

import com.core.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 聚合文档 微服务
 * @author daixu
 * @date 2022-05-13 09:45
 */
@EnableAsync
@EnableFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class PluginDocApplication {
    public static void main(String[] args) {
        SpringApplication.run(PluginDocApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  聚合文档模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "  _________ __                 __      _________                                          _____     .__  .__         \n" +
                " /   _____//  |______ ________/  |_   /   _____/__ __   ____  ____  ____   ______ _______/ ____\\_ __|  | |  | ___.__.\n" +
                " \\_____  \\\\   __\\__  \\\\_  __ \\   __\\  \\_____  \\|  |  \\_/ ___\\/ ___\\/ __ \\ /  ___//  ___/\\   __\\  |  \\  | |  |<   |  |\n" +
                " /        \\|  |  / __ \\|  | \\/|  |    /        \\  |  /\\  \\__\\  \\__\\  ___/ \\___ \\ \\___ \\  |  | |  |  /  |_|  |_\\___  |\n" +
                "/_______  /|__| (____  /__|   |__|   /_______  /____/  \\___  >___  >___  >____  >____  > |__| |____/|____/____/ ____|\n" +
                "        \\/           \\/                      \\/            \\/    \\/    \\/     \\/     \\/                       \\/"
        );
    }
}

