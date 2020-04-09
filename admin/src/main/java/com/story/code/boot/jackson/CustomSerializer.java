package com.story.code.boot.jackson;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 *  自定义Jackson序列化
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/7 by Storys.Zhang
 */
abstract class CustomSerializer<T> extends StdSerializer<T> {

    protected CustomSerializer(Class<T> t) {
        super(t);
    }

}
