package com.story.code.boot.exception.custom;

import com.story.code.boot.exception.InternalErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/26 by Storys.Zhang
 */
public class GlobalException extends ResponseStatusException {

    @Getter
    protected InternalErrorCodeEnum errorCodeEnum;

    public GlobalException(HttpStatus status) {
        super(status);
    }

    public GlobalException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public GlobalException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public GlobalException setErrorCodeEnum(InternalErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
        return this;
    }
}
