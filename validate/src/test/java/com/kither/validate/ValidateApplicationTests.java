package com.kither.validate;

import com.kither.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJwt() {
        String token = JwtUtil.generateToken();
        System.out.println(token);

        Claims claims = JwtUtil.parseToken(token);
        System.out.println(claims);
    }
}
