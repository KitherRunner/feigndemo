package com.kither.consumer.configure;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configure {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
