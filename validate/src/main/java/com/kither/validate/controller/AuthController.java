package com.kither.validate.controller;

import com.google.gson.Gson;
import com.kither.auth.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.UUID;

/**
 * 模拟oauth2.0授权
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    /**
     * 获取授权code
     *
     * @param authBean 授权参数
     * @param response
     * @throws IOException
     */
    @GetMapping("authorize")
    public void getCode(@NotNull AuthBean authBean, HttpServletResponse response) throws IOException {
        AuthResult authResult = Auth2Util.validateApplyCodeParam(authBean);
        if (authResult.isSuccess()) {
            StringBuilder redirectUrlBuilder = new StringBuilder(authBean.getRedirectUri()).append("?code=").append(uuid());
            String state;
            if (StringUtils.isNotBlank(state = authBean.getState())) {
                redirectUrlBuilder.append("&state=").append(state);
            }
            response.sendRedirect(redirectUrlBuilder.toString());
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(new Gson().toJson(authResult).getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 获取授权token
     *
     * @param authBean 授权参数
     * @return
     */
    @GetMapping("accessToken")
    public AuthResult accessToken(@NotNull AuthBean authBean) {
        AuthResult authResult = Auth2Util.validateAccessTokenParam(authBean);
        if (authResult.isSuccess()) {
            authResult.setAccessToken(uuid());
            authResult.setRefreshToken(uuid());
            authResult.setExpire(System.currentTimeMillis() + 60000);
        }
        return authResult;
    }

    @GetMapping(value = "valid/authorize")
    public void getCodeWithValid(@NotNull @Validated(AuthorizeCode.class) AuthBean authBean, HttpServletResponse response) throws IOException {
        StringBuilder redirectUrlBuilder = new StringBuilder(authBean.getRedirectUri()).append("?code=").append(uuid());
        String state;
        if (StringUtils.isNotBlank(state = authBean.getState())) {
            redirectUrlBuilder.append("&state=").append(state);
        }
        response.sendRedirect(redirectUrlBuilder.toString());
    }

    @GetMapping(value = "valid/accessToken")
    public AuthResult accessTokenWithValid(@NotNull @Validated(AuthorizeToken.class) AuthBean authBean) {
        AuthResult.AuthResultBuilder builder = AuthResult.builder();
        builder.accessToken(uuid());
        builder.refreshToken(uuid());
        builder.expire(System.currentTimeMillis() + 60000);
        builder.success(true);
        builder.code(200);
        return builder.build();
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
