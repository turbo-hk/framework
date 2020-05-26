package com.story.code.domain.sys.dto;

import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.component.collection.difference.DataPersistCollectionDifferenceComponent;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
@Data
public class UserPersistDTO {

    private Long id;

    private String loginName;

    private String mobile;

    private String tel;

    private Long organizationId;

    private String password;

    private String salt;

    private DataPersistCollectionDifferenceComponent<Long> roleIds;

    private DataPersistCollectionDifferenceComponent<Long> groupIds;

    private TokenLoginUser loginUser;

}
