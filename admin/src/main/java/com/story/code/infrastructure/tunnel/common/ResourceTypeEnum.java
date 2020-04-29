package com.story.code.infrastructure.tunnel.common;

import lombok.Getter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/29 by Storys.Zhang
 */
@Getter
public enum ResourceTypeEnum {

    MENU("menu", "菜单"),
    PAGE_ELEMENT("page_element", "页面元素"),
    ;


    private String type;
    private String name;

    ResourceTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
