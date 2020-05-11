package com.story.code.app.sys.vo;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/6 by Storys.Zhang
 */
@Data
public class UserPageListVO {

    private String loginName;

    private String mobile;

    private Long organizationId;

    private String organizationName;

    private String tel;

    private Long tenantId;

    private Boolean disabled;

}
