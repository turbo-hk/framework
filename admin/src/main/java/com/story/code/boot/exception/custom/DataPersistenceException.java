package com.story.code.boot.exception.custom;

import com.story.code.boot.exception.InternalErrorCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * 数据持久化异常
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
public class DataPersistenceException extends GlobalException {

    public DataPersistenceException(HttpStatus status) {
        super(status);
    }

    public DataPersistenceException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public DataPersistenceException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public static void verify(int count, String reason) {
        if (count == 0) {
            DataPersistenceException exception = new DataPersistenceException(InternalErrorCodeEnum.INTERNAL_DATA_PERSIST_ERROR.getHttpStatus(), reason);
            exception.setErrorCodeEnum(InternalErrorCodeEnum.INTERNAL_DATA_PERSIST_ERROR);
            throw exception;
        }
    }
}
