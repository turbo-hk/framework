package com.story.code.helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author storys.zhang@gmail.com
 * @see https://www.baeldung.com/java-date-to-localdate-and-localdatetime
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
public final class LocalDateTimeHelper {

    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
            .from(dateToConvert.atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
