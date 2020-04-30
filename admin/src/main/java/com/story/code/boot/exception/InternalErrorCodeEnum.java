package com.story.code.boot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 内部错误码
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/26 by Storys.Zhang
 */
@Getter
public enum InternalErrorCodeEnum {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"50000", "INTERNAL SERVER ERROR"),
    INTERNAL_DATA_PERSIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"50001", "数据持久化异常"),
    LOGIN_REQUIRED(HttpStatus.FORBIDDEN, "40301", "token失效");

    private final HttpStatus httpStatus;
    private final String code;
    private final String name;

    InternalErrorCodeEnum(HttpStatus httpStatus, String code, String name) {
        this.code = code;
        this.name = name;
        this.httpStatus = httpStatus;
    }
}
