package com.story.code.common;

import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/15 by Storys.Zhang
 */
@Data
public class NumericalRangeVO<T extends Number> {

    private T start;

    private T end;

}
