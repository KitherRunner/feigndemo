package com.kither.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class ProviderController {

    @GetMapping(value = "hello", produces = "text/plain;charset=utf-8")
    public String hello() {
        return "hello";
    }
}
