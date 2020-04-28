package com.story.code.domain.sys.repository;

import com.story.code.domain.sys.converter.RoleConverter;
import com.story.code.domain.sys.valueobject.RoleVO;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupRoleDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.GroupRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.RoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/28 by Storys.Zhang
 */
@Repository
public class UserRoleRepository {

    @Autowired
    private UserRoleTunnelI userRoleTunnel;
    @Autowired
    private RoleTunnelI roleTunnel;
    @Autowired
    private RoleConverter roleConverter;
    @Autowired
    private GroupRoleTunnelI groupRoleTunnel;

    public List<RoleVO> customRoles(Long userId){
        List<Long> roleIds = userRoleTunnel.listByUserId(userId).stream().map(UserRoleDO::getRoleId).collect(Collectors.toList());
        return roleTunnel.listByIds(roleIds).stream().map(roleConverter::doToVo).collect(Collectors.toList());
    }

    public List<RoleVO> userGroupRoles(Long groupId) {
        List<Long> roleIds =  groupRoleTunnel.listByGroupId(groupId).stream().map(GroupRoleDO::getRoleId).collect(Collectors.toList());
        return roleTunnel.listByIds(roleIds).stream().map(roleConverter::doToVo).collect(Collectors.toList());
    }
}
