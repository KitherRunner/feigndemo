package com.kither.auth;

import org.apache.commons.lang.StringUtils;

public class Auth2Util {

    /**
     * 验证参数的正确性
     *
     * @param authBean
     * @return
     */
    public static AuthResult validateApplyCodeParam(AuthBean authBean) {
        String responseTye;
        if (StringUtils.isBlank((authBean.getClientId()))
                || StringUtils.isBlank((authBean.getSecret()))
                || StringUtils.isBlank((authBean.getRedirectUri()))
                || StringUtils.isBlank(responseTye = authBean.getResponseType())
                || !"code".equals(responseTye)) {
            return AuthResult.builder().code(500).message("clientId、secret、redirectUrl不能空,responseType必须为code").success(false).build();
        }
        return AuthResult.AuthResultBuilder.SUCCESS;
    }

    public static AuthResult validateAccessTokenParam(AuthBean authBean) {
        String grantType;
        if (StringUtils.isBlank((authBean.getClientId()))
                || StringUtils.isBlank((authBean.getSecret()))
                || StringUtils.isBlank((authBean.getRedirectUri()))
                || StringUtils.isBlank(grantType = authBean.getGrantType())
                || !"authorization_code".equals(grantType)) {
            return AuthResult.builder().code(500).message("clientId、secret、redirectUrl不能空,grantType必须为authorization_code").success(false).build();
        }
        return AuthResult.AuthResultBuilder.SUCCESS;
    }
}