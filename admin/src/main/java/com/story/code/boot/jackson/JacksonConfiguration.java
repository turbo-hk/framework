package com.story.code.boot.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.story.code.component.page.query.PageQuery;
import com.story.code.component.page.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Jackson配置
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/7 by Storys.Zhang
 */
@Slf4j
@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        log.info("----->>------->>>>>>>>>>>>>Init jackson configuration");
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule module = new SimpleModule("customModule");
        module.addSerializer(new PageResponseSerializer(PageVO.class));
        module.addDeserializer(PageQuery.class, new PageRequestDeserializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
