package com.story.code.field.desc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/11 by Storys.Zhang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface FieldDescAnnotation {

    String desc() default "";

    String dictNode() default "";

}
