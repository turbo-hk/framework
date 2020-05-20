package com.story.code.app.sys.converter;

import com.story.code.app.sys.command.UserPersistCommand;
import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.boot.security.LoginPasswordEncoder;
import com.story.code.common.DictVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDTO;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.common.enums.BooleanColumnEnum;
import com.story.code.domain.dict.valueobject.DictNodeCodeEnum;
import com.story.code.domain.dict.valueobject.DictValueVO;
import com.story.code.domain.sys.dto.UserPersistDTO;
import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class UserAppConverter implements RequestQueryToDatabaseParam<UserPageListQuery, UserPageListParam>,
    DataObjectToValueObject<UserDO, UserPageListVO>, RequestQueryToDTO<UserPersistCommand, UserPersistDTO> {

    @Autowired
    private LoginPasswordEncoder loginPasswordEncoder;
    @Autowired
    private OrganizationTunnelI organizationTunnel;
    @Autowired
    private UserGroupTunnelI userGroupTunnel;

    @Override
    public UserPageListVO doToVo(UserDO data) {
        UserPageListVO vo = new UserPageListVO();
        vo.setLoginName(data.getLoginName());
        vo.setMobile(data.getMobile());
        vo.setOrganizationId(data.getOrganizationId());
        vo.setOrganizationName(null);
        vo.setTel(data.getTel());
        vo.setTenantId(data.getTenantId());
        int disabled = BooleanColumnEnum.convert(data.getDisabled());
        Optional<DictValueVO> dictValue = DictNodeCodeEnum.DISABLED.ops().getDictValue(String.valueOf(disabled));
        vo.setDisabled(new DictVO<Integer>(disabled, dictValue.orElse(new DictValueVO()).getValue()));
        return vo;
    }

    @Override
    public UserPageListParam toParam(UserPageListQuery query) {
        UserPageListParam param = new UserPageListParam();
        param.setUserName(query.getUserName());
        param.setDisabled(BooleanColumnEnum.convert(query.getDisabled()).getBooleanValue());
        return param;
    }

    @Override
    public UserPersistDTO toDto(UserPersistCommand command) {
        UserPersistDTO dto = new UserPersistDTO();
        dto.setId(command.getId());
        dto.setLoginName(command.getLoginName());
        dto.setMobile(command.getMobile());
        dto.setTel(command.getTel());
        dto.setOrganizationId(command.getOrganizationId());
        String randomSalt = loginPasswordEncoder.randomSalt();
        String encodePassword= loginPasswordEncoder.encode(command.getPassword(), randomSalt);
        dto.setPassword(encodePassword);
        dto.setSalt(randomSalt);
        dto.setRoleIds(CollectionHelper.nullToEmpty(command.getRoleIds()));
        List<Long> groupIds = command.getGroupIds();
        if (CollectionHelper.isNotEmpty(groupIds)){

        }
        dto.setGroupIds(CollectionHelper.nullToEmpty(groupIds));
        OrganizationDO organization = organizationTunnel.get(command.getOrganizationId());
        dto.setDataScopeOrganizationUid(organization.getUid());
        return dto;
    }
}
