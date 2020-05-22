package com.story.code.app.sys.validator;

import com.story.code.app.sys.command.UserPersistCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
@Slf4j
@Component
public class UserPersistValidator {
    public void validateAdd(UserPersistCommand command){
        log.debug("新建user验证器{}", command);
    }

    public void validateUpdate(UserPersistCommand command){
        log.debug("编辑user验证器{}", command);
    }
}
