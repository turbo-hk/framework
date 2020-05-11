package com.story.code.app.sys.vo;

import com.story.code.field.desc.FieldDescAnnotation;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
@Data
public class MenuPageListVO {

    @FieldDescAnnotation(desc = "我是张三")
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
