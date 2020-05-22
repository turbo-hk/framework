package com.story.code.app.sys.validator;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/22 by Storys.Zhang
 */
@Slf4j
@Component
public class OrganizationPersistValidator {
    public void validateAdd(OrganizationPersistCommand command) {
        log.debug("新建Organization验证器{}", command);
    }

    public void validateUpdate(OrganizationPersistCommand command) {
        log.debug("编辑Organization验证器{}", command);
    }
}
