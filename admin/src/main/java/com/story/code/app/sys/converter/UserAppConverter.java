package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
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
        return null;
    }

    @Override
    public UserPageListParam toParam(UserPageListQuery query) {
        return null;
    }
}
