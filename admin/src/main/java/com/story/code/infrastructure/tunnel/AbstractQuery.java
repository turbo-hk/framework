package com.story.code.infrastructure.tunnel;

import static com.story.code.infrastructure.tunnel.common.Constants.DEL_FLAG_FALSE;

import com.story.code.boot.security.TenantIdUtil;
import java.util.Optional;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Data
public abstract class AbstractQuery {

    private Integer DEL_FLAG = DEL_FLAG_FALSE;

    private Long tenantId;

    public Long getTenantId() {
        return Optional.ofNullable(tenantId).orElse(TenantIdUtil.getTenantId());
    }
}
