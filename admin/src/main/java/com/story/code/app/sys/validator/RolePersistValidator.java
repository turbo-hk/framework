package com.story.code.app.sys.validator;

import com.story.code.app.sys.command.GroupPersistCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Slf4j
@Component
public class GroupPersistValidator {
    public void validate(GroupPersistCommand command){
        log.debug("新建group验证器{}", command);
    }
}
