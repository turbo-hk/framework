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
import com.story.code.component.collection.difference.DataPersistCollectionDifferenceComponent;
import com.story.code.domain.dict.valueobject.DictNodeCodeEnum;
import com.story.code.domain.dict.valueobject.DictValueVO;
import com.story.code.domain.sys.dto.UserPersistDTO;
import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class  UserAppConverter implements RequestQueryToDatabaseParam<UserPageListQuery, UserPageListParam>,
    DataObjectToValueObject<UserDO, UserPageListVO>, RequestQueryToDTO<UserPersistCommand, UserPersistDTO> {

    @Autowired
    private LoginPasswordEncoder loginPasswordEncoder;
    @Autowired
    private OrganizationTunnelI organizationTunnel;
    @Autowired
    private UserGroupTunnelI userGroupTunnel;
    @Autowired
    private UserRoleTunnelI userRoleTunnel;

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
        Long id = command.getId();
        UserPersistDTO dto = new UserPersistDTO();
        dto.setId(id);
        dto.setLoginName(command.getLoginName());
        dto.setMobile(command.getMobile());
        dto.setTel(command.getTel());
        dto.setOrganizationId(command.getOrganizationId());
        String randomSalt = loginPasswordEncoder.randomSalt();
        String encodePassword = loginPasswordEncoder.encode(command.getPassword(), randomSalt);
        dto.setPassword(encodePassword);
        dto.setSalt(randomSalt);
        List<Long> groupIds = command.getGroupIds();
        Set<Long> dataGroupIds = userGroupTunnel.listByUserId(id).stream().map(UserGroupDO::getGroupId).collect(Collectors.toSet());
        dto.setGroupIds(new DataPersistCollectionDifferenceComponent<Long>(CollectionHelper.nullToEmpty(groupIds), dataGroupIds));

        List<Long> roleIds = command.getRoleIds();
        Set<Long> dataRoleIds = userRoleTunnel.listByUserId(id).stream().map(UserRoleDO::getRoleId).collect(Collectors.toSet());
        dto.setRoleIds(new DataPersistCollectionDifferenceComponent<Long>(CollectionHelper.nullToEmpty(roleIds), dataRoleIds));
        //OrganizationDO organization = organizationTunnel.get(command.getOrganizationId());
        return dto;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 65535000; i++) {
            builder.append(i);
        }
        System.out.println(builder.toString());
        System.out.println(builder.toString().length());
        System.out.println(65535);
        System.out.println(Integer.MAX_VALUE);
    }
}
