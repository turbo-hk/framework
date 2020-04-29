package com.story.code.domain.sys.factory;

import com.story.code.boot.SpringContextHolder;
import com.story.code.domain.sys.aggregation.UserAuthorityAggregation;
import com.story.code.domain.sys.entity.UserEntity;
import com.story.code.domain.sys.entity.UserGroupEntity;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/29 by Storys.Zhang
 */
@Component
public class UserAuthorityFactory {

    @Autowired
    private UserGroupTunnelI userGroupTunnel;

    public UserAuthorityAggregation userAuthorityAggregation(Long userId) {
        UserEntity userEntity = SpringContextHolder.getBean(UserEntity.class);
        userEntity.setId(userId);

        List<UserGroupDO> userGroupDOList = userGroupTunnel.listByUserId(userId);
        List<UserGroupEntity> userGroupEntityList = userGroupDOList.stream().map(userGroupDO -> {
            UserGroupEntity groupEntity = SpringContextHolder.getBean(UserGroupEntity.class);
            groupEntity.setGroupId(userGroupDO.getGroupId());
            groupEntity.setUserId(userGroupDO.getUserId());
            return groupEntity;
        }).collect(Collectors.toList());

        UserAuthorityAggregation aggregation = SpringContextHolder.getBean(UserAuthorityAggregation.class);
        aggregation.setUserEntity(userEntity);
        aggregation.setUserGroupEntityList(userGroupEntityList);
        return aggregation;
    }
}
