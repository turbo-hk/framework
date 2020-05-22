package com.story.code.app.sys.command;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
@Data
public class OrganizationPersistCommand {

    private Long id;

    private Long parentId;

    private String name;

    private Integer rankNum;

}
