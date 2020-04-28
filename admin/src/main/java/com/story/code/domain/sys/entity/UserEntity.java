package com.story.code.domain.sys.entity;

import com.story.code.domain.sys.repository.UserRoleRepository;
import com.story.code.domain.sys.valueobject.RoleVO;
import java.util.List;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/27 by Storys.Zhang
 */
public class UserEntity {

    private Long id;

    private List<UserGroupEntity> userGroupList;

    private List<RoleVO> customRoleList;



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
