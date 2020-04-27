package com.story.code.app.sys.controller;

import com.story.code.app.sys.command.MenuPersistCommand;
import com.story.code.app.sys.query.MenuPageListQuery;
import com.story.code.app.sys.service.MenuService;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.DefaultVO;
import com.story.code.component.page.vo.PageVO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
@RestController
@RequestMapping(value = "/sys/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @SneakyThrows
    @PostMapping("/page")
    public Mono<ApiResponseVO<PageVO<MenuPageListVO>>> page(@RequestBody MenuPageListQuery query) {
        //Mono<Long> userId = SecurityUtils.getUserId();

        return SecurityUtils.getUserId().map(f -> service.page(query)).doOnSuccess(c -> {
            System.out.println("----" + c);
        });
    }

/*    @PostMapping("/list")
    public Mono<ApiResponseVO<MenuListVO>> list() {
        return Mono.just(service.list(SecurityUtils.));
    }*/

    @PostMapping("/add")
    public Mono<ApiResponseVO<DefaultVO>> add(@RequestBody MenuPersistCommand command) {
        return Mono.just(service.add(command));
    }

    @PostMapping("/update")
    public Mono<ApiResponseVO<DefaultVO>> update(@RequestBody MenuPersistCommand command) {
        return Mono.just(service.update(command));
    }

}
