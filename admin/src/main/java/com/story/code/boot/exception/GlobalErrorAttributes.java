package com.story.code.boot.exception;

import com.alibaba.fastjson.JSONObject;
import com.story.code.boot.exception.custom.GlobalException;
import com.story.code.common.ApiResponseVO;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/26 by Storys.Zhang
 */
@Slf4j
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        return assembleError(request);
    }

    private Map<String, Object> assembleError(ServerRequest request) {
        Throwable error = getError(request);
        log.error("未知异常:", error);
        ApiResponseVO responseVO = null;
        if (error instanceof GlobalException) {
            responseVO = ApiResponseVO.<Void>create().message(error.getMessage()).internalErrorCode(((GlobalException) error).getErrorCodeEnum().getCode())
                .buildError();
        } else {
            responseVO = ApiResponseVO.<Void>create().message(error.getMessage()).internalErrorCode(InternalErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode())
                .buildError();
        }
        Map<String, Object> errorAttributes = JSONObject.parseObject(JSONObject.toJSONString(responseVO), Map.class);
        return errorAttributes;
    }
}
