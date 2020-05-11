package com.story.code.common.enums;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/11 by Storys.Zhang
 */
public enum BooleanColumnEnum {

    _TRUE(1, Boolean.TRUE),
    _FALSE(0, Boolean.FALSE);

    @Getter
    private final Integer value;

    @Getter
    private final Boolean booleanValue;

    BooleanColumnEnum(Integer value, Boolean booleanValue) {
        this.value = value;
        this.booleanValue = booleanValue;
    }

    public static Optional<BooleanColumnEnum> of(Integer value) {
        return Arrays.stream(BooleanColumnEnum.values()).filter(p -> p.getValue().equals(value)).findFirst();
    }

    public static BooleanColumnEnum convert(Integer value) {
        if (_TRUE.getValue().equals(value)) {
            return _TRUE;
        }
        return _FALSE;

    }
}
