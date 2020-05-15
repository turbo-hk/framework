package com.story.code.common;

import java.time.temporal.Temporal;
import lombok.Data;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/15 by Storys.Zhang
 */
@Data
public class LocalDateRangeVO<T extends Temporal> {

    private T start;

    private T end;

}
