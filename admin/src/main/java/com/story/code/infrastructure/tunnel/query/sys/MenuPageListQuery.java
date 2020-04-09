package com.story.code.infrastructure.tunnel.query.sys;

import com.story.code.infrastructure.tunnel.AbstractQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuPageListQuery extends AbstractQuery {

    private Long parentId;
}
