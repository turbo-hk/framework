package com.story.code.domain.dict.repository;

import com.story.code.boot.security.TenantIdUtil;
import com.story.code.domain.dict.converter.DictNodeConverter;
import com.story.code.domain.dict.converter.DictValueConverter;
import com.story.code.domain.dict.valueobject.DictNodeVO;
import com.story.code.domain.dict.valueobject.DictValueVO;
import com.story.code.infrastructure.tunnel.dataobject.dict.DictNodeDO;
import com.story.code.infrastructure.tunnel.dataobject.dict.DictValueDO;
import com.story.code.infrastructure.tunnel.datatunnel.DictNodeTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.DictValueTunnelI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Repository
public class DictRepository {

    @Autowired
    private DictNodeTunnelI dictNodeTunnel;
    @Autowired
    private DictValueTunnelI dictValueTunnel;
    @Autowired
    private DictNodeConverter dictNodeConverter;
    @Autowired
    private DictValueConverter dictValueConverter;

    public Optional<DictNodeVO> getDict(String dictNodeCode) {
        DictNodeDO data = dictNodeTunnel.getByCode(dictNodeCode.toUpperCase(), TenantIdUtil.getTenantId());
        if (Objects.isNull(data)) {
            return Optional.empty();
        }
        DictNodeVO dictNodeVO = dictNodeConverter.doToVo(data);
        List<DictValueDO> dictValueList = dictValueTunnel.listByNodeId(data.getId());
        List<DictValueVO> dictValueVOList = dictValueList.stream().map(dictValueConverter::doToVo).sorted(DictValueVO::compareTo).collect(Collectors.toList());
        dictNodeVO.setDictValueList(dictValueVOList);
        return Optional.of(dictNodeVO);
    }

    public Optional<DictValueVO> getDictValue(String dictNodeCode, String dictValueCode) {
        Optional<DictNodeVO> dictNodeVOOptional = getDict(dictNodeCode);
        if (!dictNodeVOOptional.isPresent()) {
            return Optional.empty();
        }
        return dictNodeVOOptional.get().getDictValueList().stream().filter(p -> p.getCode().equals(dictValueCode)).findAny();
    }

}
