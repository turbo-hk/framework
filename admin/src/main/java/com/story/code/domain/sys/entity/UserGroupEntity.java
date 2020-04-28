package com.story.code.domain.sys.entity;

import com.story.code.domain.sys.valueobject.RoleVO;
import java.util.List;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/28 by Storys.Zhang
 */
public class UserGroupEntity {

    private Long id;

    private List<RoleVO> roleList;

    private List<UserEntity> userList;

}
