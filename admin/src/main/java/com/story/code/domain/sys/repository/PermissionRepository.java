package com.story.code.domain.sys.repository;

import com.story.code.boot.security.TenantIdUtil;
import com.story.code.domain.sys.valueobject.RoleVO;
import com.story.code.infrastructure.tunnel.common.ResourceTypeEnum;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceTypeDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.RolePermissionDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceMenuTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.ResourcePermissionTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceTypeTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.RolePermissionTunnelI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/29 by Storys.Zhang
 */
@Repository
public class PermissionRepository {

    @Autowired
    private RolePermissionTunnelI rolePermissionTunnel;
    @Autowired
    private ResourcePermissionTunnelI resourcePermissionTunnel;
    @Autowired
    private ResourceTypeTunnelI resourceTypeTunnel;
    @Autowired
    private ResourceMenuTunnelI resourceMenuTunnel;

    public List<ResourceMenuDO> listMenu(List<RoleVO> roleVOList) {
        List<Long> roleIds = roleVOList.stream().map(RoleVO::getId).collect(Collectors.toList());
        List<Long> permissionIds = rolePermissionTunnel.listByRoleIds(roleIds).stream().map(RolePermissionDO::getPermissionId).collect(Collectors.toList());

        ResourceTypeDO resourceType = resourceTypeTunnel.listByTenantId(TenantIdUtil.getTenantId()).stream().filter(p -> p.getType().equals(ResourceTypeEnum.MENU.getType()))
            .findAny().get();

        List<Long> resourceIds = resourcePermissionTunnel.listByIds(permissionIds).parallelStream().filter(p -> p.getResourceTypeId().equals(resourceType.getId()))
            .map(ResourcePermissionDO::getResourceId).collect(
                Collectors.toList());
        List<ResourceMenuDO> resourceMenus = resourceMenuTunnel.listByIds(resourceIds);
        return resourceMenus;
    }

}
