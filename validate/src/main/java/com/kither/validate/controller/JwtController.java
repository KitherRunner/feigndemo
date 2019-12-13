package com.kither.validate.controller;

import com.kither.auth.AuthResult;
import com.kither.jwt.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validate")
public class JwtController {

    @GetMapping("/code")
    public AuthResult generateToken() {
        return AuthResult.builder().success(true).code(200).message(JwtUtil.generateToken()).build();
    }
}
