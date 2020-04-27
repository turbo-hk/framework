package com.story.code.app.sys.vo;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
@Data
public class MenuPageListVO {

    private Long id;

    private Long parentId;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String url;

    /**
     *
     */
    private String icon;

}
