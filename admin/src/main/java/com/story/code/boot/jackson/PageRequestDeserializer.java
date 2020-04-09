package com.story.code.boot.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.story.code.boot.SpringContextHolder;
import com.story.code.component.page.query.PageQuery;
import java.io.IOException;
import java.util.Objects;

/**
 * 分页请求参数，通过jackson序列化json时处理适配, 通过JacksonConfiguration.objectMapper.SimpleModule进行注册
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public class PageRequestDeserializer extends JsonDeserializer<PageQuery> {

    @Override
    public PageQuery deserialize(JsonParser p, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode jsonNode = p.getCodec().readTree(p);
        PageFieldConfiguration pageAdapter = SpringContextHolder.getBean(PageFieldConfiguration.class);
        JsonNode currentJsonNode = jsonNode.get(pageAdapter.getCurrent());
        int current = Objects.nonNull(currentJsonNode) ? currentJsonNode.numberValue().intValue() : 1;
        JsonNode pageSizeJsonNode = jsonNode.get(pageAdapter.getPageSize());
        int pageSize = Objects.nonNull(pageSizeJsonNode) ? pageSizeJsonNode.numberValue().intValue() : 10;
        PageQuery query = new PageQuery();
        query.setCurrent(current);
        query.setPageSize(pageSize);
        return query;
    }
}
