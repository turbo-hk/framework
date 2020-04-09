package com.story.code.boot.jackson;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * 自定义Jackson反序列化
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
abstract class CustomDeserializer<T> extends StdDeserializer<T> {

    protected CustomDeserializer(Class<?> vc) {
        super(vc);
    }

}
