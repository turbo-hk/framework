/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:00 by Storys.Zhang
 */
public interface GroupDAO extends AbstractDAO<GroupDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(@Param("id") Long id);

    /**
     * 查询一个组下面的子组
     *
     * @param parentId
     * @return
     */
    List<GroupDO> listByParentId(@Param("parentId") Long parentId);
}