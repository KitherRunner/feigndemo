package com.kither.auth;

public class AuthResult {

    private int code;
    private String message;
    private boolean success;
    private String accessToken;
    private String refreshToken;
    private Long expire;

    public AuthResult() {
    }

    public AuthResult(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static AuthResultBuilder builder() {
        return new AuthResultBuilder();
    }

    static class AuthResultBuilder {
        private int code;
        private String message;
        private boolean success;
        public static final AuthResult SUCCESS = new AuthResult(200, null, true);
        public static final AuthResult FAILURE = new AuthResult(500, "请求错误", false);

        public AuthResultBuilder code(int code) {
            this.code = code;
            return this;
        }

        public AuthResultBuilder message(String message) {
            this.message = message;
            return this;
        }

        public AuthResultBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public AuthResult build() {
            return new AuthResult(code, message, success);
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }
}
