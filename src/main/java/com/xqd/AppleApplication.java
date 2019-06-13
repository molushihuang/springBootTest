package com.xqd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.xqd.dao")
@SpringBootApplication
@EnableSwagger2
@Configuration
/**
 * 定时任务开启
 */
@EnableScheduling
/**
 * (maxInactiveIntervalInSeconds=60) 默认是1800秒过期，这里测试修改为60秒session过期配置
 *
 * @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 24 * 7)
 */
/**
 * 开启redis
 *
 * @EnableCaching
 */
/**
 *
 * @author 谢邱东
 *
 */
public class AppleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppleApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务启动完毕.");
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setSessionTimeout(1800);
            }
        };
    }

}
