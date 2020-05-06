package com.story.code.domain.sys.valueobject;

import java.io.Serializable;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/28 by Storys.Zhang
 */
@Data
public class RoleVO implements Serializable {

    private static final long serialVersionUID = -4184822946689657841L;

    private Long id;

    private String name;

    private String code;

}
