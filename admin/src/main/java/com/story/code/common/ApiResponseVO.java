package com.story.code.common;

import java.util.Objects;
import lombok.Getter;
import lombok.ToString;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2019/1/18 by Storys.Zhang
 */
@Getter
@ToString
public class ApiResponseVO<T> {

    private Integer code;

    private String message;

    private String internalErrorCode;

    private T data;

    public static <T> Builder<T> create() {
        return new Builder<>();
    }

    public boolean success() {
        return 0 == this.code;
    }

    public ApiResponseVO(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
        this.internalErrorCode = builder.internalErrorCode;
    }

    public static class Builder<T> {

        private Integer code;

        private String message;

        private String internalErrorCode;

        private T data;

        public Builder code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder internalErrorCode(String internalErrorCode) {
            this.internalErrorCode = internalErrorCode;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponseVO<T> buildSuccess() {
            if (Objects.isNull(this.code)) {
                this.code = 0;
            }
            if (Objects.isNull(this.message)) {
                this.message = "success";
            }
            ApiResponseVO vo = new ApiResponseVO(this);
            return vo;
        }

        public ApiResponseVO<T> buildError() {
            if (Objects.isNull(this.code)) {
                this.code = -1;
            }
            if (Objects.isNull(this.message)) {
                this.message = "fail";
            }
            ApiResponseVO vo = new ApiResponseVO(this);
            return vo;
        }
    }

    public static ApiResponseVO<DefaultVO> defaultSuccessful() {
        return ApiResponseVO.<DefaultVO>create().buildSuccess();
    }
}
