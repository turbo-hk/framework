package com.story.code.domain.dict.valueobject;

import java.util.List;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Data
public class DictNodeVO {

    private String code;

    private String title;

    private List<DictValueVO> dictValueList;
}
