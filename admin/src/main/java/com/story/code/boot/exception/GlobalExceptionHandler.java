/*
package com.story.code.boot.exception;

import com.story.code.boot.exception.custom.RequiredLoginException;
import com.story.code.common.ApiResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

*/
/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 *//*

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponseVO<Void> handleException(Exception e) {
        log.error("未知异常:", e);
        return ApiResponseVO.create().message(e.getMessage()).internalErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).buildError();
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponseVO<Void> handleBadCredentialsException(BadCredentialsException e) {
        log.error("用户名或密码错误:", e);
        return ApiResponseVO.create().message("用户名或密码错误").internalErrorCode("login").buildError();
    }

    @ExceptionHandler(RequiredLoginException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ApiResponseVO<Void> handleRequiredLoginException(RequiredLoginException e) {
        log.error("Token已过期:", e);
        return ApiResponseVO.create().message("请重新登录").internalErrorCode("login").buildError();
    }

}
*/
