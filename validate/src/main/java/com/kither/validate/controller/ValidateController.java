package com.kither.validate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class ValidateController {

    @GetMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    public String hello() {
        return "validate hello";
    }
}
