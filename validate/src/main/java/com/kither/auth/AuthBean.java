package com.kither.auth;

import com.kither.annotation.Equals;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AuthBean implements Serializable {
    /**
     * group：分组校验
     */
    @NotNull(message = "clientId不能为空", groups = AuthorizeCode.class)
    private String clientId;

    @NotNull(message = "secret不能为空", groups = AuthorizeCode.class)
    private String secret;

    @NotNull(message = "redirectUri不能为空", groups = AuthorizeCode.class)
    private String redirectUri;

    @NotNull(message = "responseType不能为空", groups = AuthorizeCode.class)
    @Equals(value = "code", message = "responseType值必须等于code", groups = AuthorizeCode.class)
    private String responseType;

    private String scope;

    private String state;

    @NotNull(message = "code不能为空", groups = AuthorizeToken.class)
    private String code;

    @NotNull(message = "grantType不能为空", groups = AuthorizeToken.class)
    @Equals(value = "authorization_code", message = "grantType值必须等于authorization_code", groups = AuthorizeToken.class)
    private String grantType;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
