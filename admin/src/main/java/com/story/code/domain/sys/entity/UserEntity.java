package com.story.code.domain.sys.entity;

import com.story.code.domain.sys.repository.UserRoleRepository;
import com.story.code.domain.sys.valueobject.RoleVO;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/27 by Storys.Zhang
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserEntity {

    @Setter
    private Long id;

    private List<RoleVO> customRoleList;

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 用户自定义角色
     *
     * @return
     */
    public List<RoleVO> getCustomRoleList() {
        return userRoleRepository.customRoles(this.id);
    }
}
