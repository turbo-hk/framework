/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:41 by Storys.Zhang
 */
public interface UserGroupDAO extends AbstractDAO<UserGroupDO> {

    /**
     * 查询用户组列表
     *
     * @param userId
     * @return
     */
    List<UserGroupDO> listByUserId(@Param("userId") Long userId);

    /**
     * 根据组合主键删除
     *
     * @param userId
     * @param groupId
     * @return
     */
    int deleteByUserIdAndGroupId(@Param("userId") Long userId, @Param("groupId") Long groupId);
}