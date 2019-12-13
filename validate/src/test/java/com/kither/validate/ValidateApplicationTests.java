package com.kither.validate;

import com.kither.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

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

    @Test
    public void testAuth() throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder("http://localhost:9005/auth/authorize");
        uriBuilder.addParameter("responseType", "code");
        uriBuilder.addParameter("clientId", "1234567");
        uriBuilder.addParameter("secret", "1234567");
        uriBuilder.addParameter("redirectUri", "http://localhost:9005/auth");
        uriBuilder.addParameter("state", "stateCode");
        HttpGet get = new HttpGet(uriBuilder.build());
        CloseableHttpResponse execute = client.execute(get);
        System.out.println(EntityUtils.toString(execute.getEntity()));
    }

    @Test
    public void testAccessToken() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder("http://localhost:9005/auth/accessToken");
        uriBuilder.addParameter("grantType", "authorization_code");
        uriBuilder.addParameter("clientId", "1234567");
        uriBuilder.addParameter("secret", "1234567");
        uriBuilder.addParameter("redirectUri", "http://localhost:9005/auth");
        uriBuilder.addParameter("state", "stateCode");
        uriBuilder.addParameter("code", "1234567");
        HttpGet get = new HttpGet(uriBuilder.build());
        CloseableHttpResponse execute = client.execute(get);
        System.out.println(EntityUtils.toString(execute.getEntity()));
    }
}
