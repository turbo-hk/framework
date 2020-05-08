package com.story.code.domain.dict.valueobject;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Data
public class DictValueVO implements Comparable<DictValueVO>{

    private String code;

    private String value;

    private Integer rankNum;

    @Override
    public int compareTo(DictValueVO o) {
        return o.getRankNum().compareTo(this.getRankNum());
    }
}
