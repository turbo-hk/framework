package com.story.code.app.sys.service;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;
import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import com.story.code.boot.exception.custom.DataPersistenceException;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.DefaultVO;
import com.story.code.helper.OrganizationUidGenerator;
import com.story.code.helper.StringHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
@Service
public class OrganizationService {

    @Autowired
    private OrganizationTunnelI organizationTunnel;

    public ApiResponseVO<DefaultVO> add(OrganizationPersistCommand command) {
        Long parentId = Optional.ofNullable(command.getParentId()).orElse(DEFAULT_LONG);
        OrganizationDO maxOrganization = Optional.ofNullable(organizationTunnel.maxByParentId(parentId)).orElse(new OrganizationDO() {{
            setParentUid(organizationTunnel.get(parentId).getUid());
        }});
        String uid = OrganizationUidGenerator.generate(StringHelper.nullToEmpty(maxOrganization.getParentUid()), maxOrganization.getUid());
        OrganizationDO record = new OrganizationDO();
        record.setName(command.getName());
        record.setParentId(parentId);
        record.setParentUid(StringHelper.nullToEmpty(maxOrganization.getParentUid()));
        record.setTenantId(TenantIdUtil.getTenantId());
        record.setUid(uid);
        int i = organizationTunnel.create(record);
        DataPersistenceException.verify(i, "保存组织机构失败");
        return defaultSuccessful();
    }

}
