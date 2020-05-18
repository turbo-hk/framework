package com.story.code.app.sys.validator;

import com.story.code.app.sys.command.MenuPersistCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/18 by Storys.Zhang
 */
@Slf4j
@Component
public class MenuPersistValidator {

    public void validate(MenuPersistCommand command){
        log.debug("新建菜单验证器{}", command);
    }
}
