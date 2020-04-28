package com.futao.springcloud.demo.alibaba.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author futao
 * @date 2020/4/28
 */
@RestController
public class UserController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/echo/{p}")
    public String echo(@PathVariable String p) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("component-alibaba-nacos");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/echo/" + p;
        return restTemplate.getForObject(url, String.class);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
