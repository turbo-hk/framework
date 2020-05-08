package com.story.code.app.sys.service;

import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.vo.PageVO;
import org.springframework.stereotype.Service;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/6 by Storys.Zhang
 */
@Service
public class UserService {

    public ApiResponseVO<PageVO<UserPageListVO>> page(UserPageListQuery query) {

        return null;
    }
}
