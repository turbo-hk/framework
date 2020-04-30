package com.story.code.app.sys.controller;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import com.story.code.app.sys.service.OrganizationService;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.DefaultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
@RestController
@RequestMapping(value = "/sys/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @PostMapping("/add")
    public Mono<ApiResponseVO<DefaultVO>> add(@RequestBody OrganizationPersistCommand command) {
        return Mono.just(service.add(command)).retry(5);
    }

}
