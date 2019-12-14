package com.kither.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
@ConfigurationProperties(prefix = "my")
public class ProviderController {

    /**
     * 不加setter/getter方无法注入属性
     */
    private String password;

    @Value("${my.github-name}")
    private String githubName;

    @GetMapping(value = "hello", produces = "text/plain;charset=utf-8")
    public String hello() {
        return "provider hello: " + password + "githubName：" + githubName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
