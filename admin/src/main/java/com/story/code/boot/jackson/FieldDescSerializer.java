package com.story.code.boot.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.field.desc.FieldDescAnnotation;
import java.lang.annotation.Annotation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/11 by Storys.Zhang
 */
@Slf4j
public class FieldDescSerializer extends JacksonAnnotationIntrospector implements Versioned {

    @Override
    public boolean isAnnotationBundle(Annotation ann) {
        Class<?> cls = ann.annotationType();
        if (FieldDescAnnotation.class == cls) {
            log.debug("FieldDescAnnotation is bundle");
            return true;
        }
        return super.isAnnotationBundle(ann);
    }

    @Override
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setAnnotationIntrospector(new FieldDescSerializer());
        MenuPageListVO menuPageListVO = new MenuPageListVO();
        menuPageListVO.setId(10L);
        System.out.println(objectMapper.writeValueAsString(menuPageListVO));
    }

}

