package com.kither.consumer.controller;

import com.kither.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;

    /**
     * restTemplate 调用时需要指定访问的全路径
     * @return
     */
    @GetMapping(value = "hello", produces = "text/plain;charset=UTF-8")
    public String hello() {
        return restTemplate.getForObject("http://127.0.0.1:9002/provider/hello", String.class);
    }

    @GetMapping(value = "helloFeign", produces = "text/plain;charset=UTF-8")
    public String helloFeign() {
        return consumerService.hello();
    }
}
