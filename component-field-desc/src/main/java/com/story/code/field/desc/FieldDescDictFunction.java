package com.story.code.field.desc;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/11 by Storys.Zhang
 */
@FunctionalInterface
public interface FieldDescDictFunction {

    /**
     * 字典值
     *
     * @param dictNode
     * @param dictValue
     * @return
     */
    String desc(String dictNode, String dictValue);
}
