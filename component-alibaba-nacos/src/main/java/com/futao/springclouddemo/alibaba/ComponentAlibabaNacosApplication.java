package com.futao.springclouddemo.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author futao
 * @date 2020/4/28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ComponentAlibabaNacosApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ComponentAlibabaNacosApplication.class);
    }

    /**
     * 如果需要使用外部常规Tomcat，则需要重写
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ComponentAlibabaNacosApplication.class);
    }
}
