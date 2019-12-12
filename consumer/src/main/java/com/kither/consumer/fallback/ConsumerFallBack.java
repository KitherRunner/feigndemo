package com.kither.consumer.fallback;

import com.kither.consumer.service.ConsumerService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFallBack implements ConsumerService {

    @Override
    public String hello() {
        return "这是consumer的熔断降级hello方法";
    }
}
