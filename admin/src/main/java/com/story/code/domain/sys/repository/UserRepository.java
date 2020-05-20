package com.story.code.domain.sys.repository;

import com.story.code.boot.security.TenantIdUtil;
import com.story.code.common.enums.BooleanColumnEnum;
import com.story.code.component.DataPersistComponent;
import com.story.code.domain.sys.dto.UserPersistDTO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserTunnelI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
@Repository
public class UserRepository {

    @Autowired
    private UserTunnelI userTunnel;
    @Autowired
    private UserGroupTunnelI userGroupTunnel;
    @Autowired
    private UserRoleTunnelI userRoleTunnel;

    @Transactional(rollbackFor = Exception.class)
    public int persist(UserPersistDTO dto) {
        DataPersistComponent<UserPersistDTO, UserDO> component = new DataPersistComponent(dto, dto.getId());
        component.addCreatePersistStrategyFunction(() -> {
            UserDO data = new UserDO();
            data.setLoginName(dto.getLoginName());
            data.setMobile(dto.getMobile());
            data.setOrganizationId(dto.getOrganizationId());
            data.setPassword(dto.getPassword());
            data.setSalt(dto.getSalt());
            data.setTel(dto.getTel());
            data.setTenantId(TenantIdUtil.getTenantId());
            data.setDisabled(BooleanColumnEnum._FALSE.getBooleanValue());
            data.setDataScopeOrganizationUid(dto.getDataScopeOrganizationUid());
            data.setDataScopeUserId(dto.getLoginUser().getLoginUserId());
            int i = userTunnel.create(data, dto.getLoginUser().getUserName());
            dto.setId(data.getId());
            return i;
        });
        component.addUpdatePersistStrategyFunction(() -> {
            UserDO data = userTunnel.get(dto.getId());
            data.setLoginName(dto.getLoginName());
            data.setMobile(dto.getMobile());
            data.setOrganizationId(dto.getOrganizationId());
            data.setPassword(dto.getPassword());
            data.setSalt(dto.getSalt());
            data.setTel(dto.getTel());
            data.setDataScopeOrganizationUid(dto.getDataScopeOrganizationUid());
            data.setDataScopeUserId(dto.getLoginUser().getLoginUserId());
            return userTunnel.update(data, dto.getLoginUser().getUserName());
        });
        int persist = component.persist();

        List<Long> groupIds = dto.getGroupIds();
        UserGroupDO userGroupRecord = null;
        for (Long groupId : groupIds) {
            userGroupRecord = new UserGroupDO();
            userGroupRecord.setGroupId(groupId);
            userGroupRecord.setUserId(dto.getId());
            persist += userGroupTunnel.create(userGroupRecord, dto.getLoginUser().getUserName());
        }
        List<Long> roleIds = dto.getRoleIds();
        UserRoleDO userRoleRecord = null;
        for (Long roleId : roleIds) {
            userRoleRecord = new UserRoleDO();
            userRoleRecord.setRoleId(roleId);
            userRoleRecord.setUserId(dto.getId());
            persist += userRoleTunnel.create(userRoleRecord, dto.getLoginUser().getUserName());
        }
        return persist;
    }
}