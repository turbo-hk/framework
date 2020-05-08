package com.story.code.app.sys.controller;

import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.service.UserService;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/6 by Storys.Zhang
 */
@RestController
@RequestMapping(value = "/sys/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/page")
    public Mono<ApiResponseVO<PageVO<UserPageListVO>>> page(@RequestBody UserPageListQuery query) {
        System.out.println("currentThread = " + Thread.currentThread().getId());
        SecurityUtils.getUserId().subscribe(c -> {
            System.out.println("c == " + c);
        });
        return SecurityUtils.getUserId().map(f -> {
            System.out.println(f);
            return service.page(query);
        }).doOnSuccess(c -> {
            System.out.println("----" + c);
        });
    }

}
