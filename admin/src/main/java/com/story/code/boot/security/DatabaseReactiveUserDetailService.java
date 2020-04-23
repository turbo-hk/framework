package com.story.code.boot.security;

import com.google.common.collect.Lists;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserTunnelI;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/20 by Storys.Zhang
 */
@Slf4j
public class DatabaseReactiveUserDetailService implements ReactiveUserDetailsService {

    @Autowired
    private UserTunnelI userTunnel;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        UserDO user = userTunnel.getByLoginName(username, TenantIdUtil.getTenantId());
        log.info(" username : {} ", username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在: " + username);
        }
        AuthenticationUser userDetail = new AuthenticationUser(user.getId(), user.getLoginName(), user.getPassword(), Lists.newArrayList());
        userDetail.setTenantId(user.getTenantId());
        userDetail.setSalt(user.getSalt());
        return Mono
            .just(userDetail);
    }

    private String[] getRoleNames(UserDO user) {
        List<String> roleNames = Lists.newArrayList();
        //todo 用户角色
        String[] strings = new String[roleNames.size()];
        return roleNames.toArray(strings);
    }
}
