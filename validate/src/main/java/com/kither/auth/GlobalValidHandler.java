package com.kither.auth;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalValidHandler {

    @ExceptionHandler(BindException.class)
    public AuthResult codeValid(BindException e, HttpServletResponse response) throws Exception {
        System.err.println("进入了advice");
        // 错误信息集合
        BindingResult bindingResult = e.getBindingResult();
        AuthResult.AuthResultBuilder builder = AuthResult.builder();
        builder.code(500);
        builder.success(false);
        if (bindingResult.hasErrors()) {
            builder.message(handlerErrors(bindingResult));
        }
        return builder.build();
    }

    private String handlerErrors(BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder builder = new StringBuilder();
        allErrors.forEach(error -> builder.append(error.getCode()).append("-").append(error.getDefaultMessage()));
        return builder.toString();
    }
}
