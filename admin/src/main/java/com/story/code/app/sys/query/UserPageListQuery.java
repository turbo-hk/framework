package com.story.code.app.sys.query;

import com.story.code.component.page.query.PageQuery;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/6 by Storys.Zhang
 */
@Data
public class UserPageListQuery {

    private PageQuery page;

    private String userName;

    private Integer disabled;

}
