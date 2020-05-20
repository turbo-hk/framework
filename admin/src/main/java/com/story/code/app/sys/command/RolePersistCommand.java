package com.story.code.app.sys.command;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Data
public class GroupPersistCommand {

    private Long id;

    private Long parentId;

    private String name;
}
