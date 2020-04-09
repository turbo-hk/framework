package com.story.code.boot.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.story.code.boot.SpringContextHolder;
import com.story.code.component.page.vo.PageVO;
import com.story.code.helper.CollectionHelper;
import java.io.IOException;
import java.util.Optional;

/**
 * 分页响应结果，通过jackson序列化json时处理适配, 通过JacksonConfiguration.objectMapper.SimpleModule进行注册
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/7 by Storys.Zhang
 */
public class PageResponseSerializer extends CustomSerializer<PageVO> {

    protected PageResponseSerializer(Class<PageVO> t) {
        super(t);
    }

    @Override
    public void serialize(PageVO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        PageFieldConfiguration pageAdapter = SpringContextHolder.getBean(PageFieldConfiguration.class);
        gen.writeNumberField(pageAdapter.getTotal(), Optional.ofNullable(value.getTotal()).orElse(0L));
        gen.writeNumberField(pageAdapter.getCurrent(), Optional.ofNullable(value.getCurrent()).orElse(0));
        gen.writeNumberField(pageAdapter.getPageSize(), Optional.ofNullable(value.getPageSize()).orElse(0));
        gen.writeObjectField(pageAdapter.getData(), Optional.ofNullable(value.getData()).orElse(CollectionHelper.EMPTY));
        gen.writeEndObject();
    }
}
