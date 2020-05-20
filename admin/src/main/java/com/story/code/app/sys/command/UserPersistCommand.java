package com.story.code.app.sys.command;

import java.util.List;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
@Data
public class UserPersistCommand {

    private Long id;

    private String loginName;

    private String mobile;

    private String tel;

    private Long organizationId;

    private String password;

    private List<Long> roleIds;

    private List<Long> groupIds;
}
