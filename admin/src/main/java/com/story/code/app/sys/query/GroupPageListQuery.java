package com.story.code.app.sys.query;

import com.story.code.component.page.query.PageQuery;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Data
public class GroupPageListQuery {

    private PageQuery page;

    private Long parentId;
}
