package com.story.code.app.sys.command;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
@Data
public class LoginCommand {

    private String loginName;

    private String password;
}
