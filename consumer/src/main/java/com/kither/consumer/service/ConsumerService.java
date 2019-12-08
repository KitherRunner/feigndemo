package com.kither.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider")
public interface ConsumerService {

    /**
     * 此处要写全路径
     * 真实访问路径：provider路径+mapping路径
     *
     * @return
     */
    @GetMapping(value = "provider/hello", produces = "text/plain;charset=utf-8")
    String hello();
}
