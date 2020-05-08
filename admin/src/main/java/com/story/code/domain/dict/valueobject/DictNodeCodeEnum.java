package com.story.code.domain.dict.valueobject;

import lombok.Getter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
public enum DictNodeCodeEnum {

    DEL_FLAG("DEL_FLAG", "删除标识"),
    DISABLED("DISABLED", "禁用标识"),
    ;

    @Getter
    private final String code;

    @Getter
    private final String title;

    DictNodeCodeEnum(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
