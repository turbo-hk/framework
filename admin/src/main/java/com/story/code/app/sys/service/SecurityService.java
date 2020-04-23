package com.story.code.app.sys.service;

import com.story.code.app.sys.vo.LoginVO;
import com.story.code.common.ApiResponseVO;
import org.springframework.stereotype.Service;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
@Service
public class SecurityService {

    public ApiResponseVO<LoginVO> login(String token) {
        LoginVO vo = new LoginVO();
        vo.setToken(token);
        return ApiResponseVO.<LoginVO>create().data(vo).buildSuccess();
    }

}
