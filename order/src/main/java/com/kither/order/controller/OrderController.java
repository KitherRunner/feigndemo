package com.kither.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping(value = "hello", produces = "text/plain;charset=utf-8")
    public String hello() {
        return "order hello";
    }
}
