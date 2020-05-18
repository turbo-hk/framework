package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.common.DictVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.common.enums.BooleanColumnEnum;
import com.story.code.domain.dict.valueobject.DictNodeCodeEnum;
import com.story.code.domain.dict.valueobject.DictValueVO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class UserAppConverter implements RequestQueryToDatabaseParam<UserPageListQuery, UserPageListParam>,
    DataObjectToValueObject<UserDO, UserPageListVO> {

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
}
