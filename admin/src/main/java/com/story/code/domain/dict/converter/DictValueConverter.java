package com.story.code.domain.dict.converter;

import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.domain.dict.valueobject.DictValueVO;
import com.story.code.infrastructure.tunnel.dataobject.dict.DictValueDO;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class DictValueConverter implements DataObjectToValueObject<DictValueDO, DictValueVO> {

    @Override
    public DictValueVO doToVo(DictValueDO data) {
        DictValueVO vo = new DictValueVO();
        vo.setCode(data.getCode());
        vo.setValue(data.getValue());
        vo.setRankNum(data.getRankNum());
        return vo;
    }
}
