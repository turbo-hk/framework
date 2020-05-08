package com.story.code.domain.dict.converter;

import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.domain.dict.valueobject.DictNodeVO;
import com.story.code.infrastructure.tunnel.dataobject.dict.DictNodeDO;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class DictNodeConverter implements DataObjectToValueObject<DictNodeDO, DictNodeVO> {

    @Override
    public DictNodeVO doToVo(DictNodeDO data) {
        DictNodeVO vo = new DictNodeVO();
        vo.setCode(data.getCode());
        vo.setTitle(data.getTitle());
        return vo;
    }


}
