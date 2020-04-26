package com.story.code.boot.exception.custom;

import com.story.code.boot.exception.InternalErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/26 by Storys.Zhang
 */
public class RequiredLoginException extends GlobalException {

    public RequiredLoginException(String reason) {
        super(InternalErrorCodeEnum.LOGIN_REQUIRED.getHttpStatus(), reason);
        super.errorCodeEnum = InternalErrorCodeEnum.LOGIN_REQUIRED;
    }

    public RequiredLoginException(HttpStatus status) {
        super(status);
    }

    public RequiredLoginException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public RequiredLoginException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }


}
