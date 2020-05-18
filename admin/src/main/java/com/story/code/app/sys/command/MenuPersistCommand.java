package com.story.code.app.sys.command;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Data
public class MenuPersistCommand {

    private Long id;

    private Long parentId;

    private Long rankNum;

    private String title;

    private String url;

    private String icon;

}
