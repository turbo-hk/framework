package com.story.code.field.desc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/11 by Storys.Zhang
 */
public class FieldDescProcessor {


    public static Map<String, Object> process(Object obj, FieldDescDictFunction dictFunction) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>(8);
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            FieldDescAnnotation fieldDescAnnotation = declaredField.getAnnotation(FieldDescAnnotation.class);
            if (Objects.isNull(fieldDescAnnotation)) {
                continue;
            }
            Object o = declaredField.get(obj);
            if (Objects.isNull(o)) {
                continue;
            }
            String desc = fieldDescAnnotation.desc();
            if (!desc.isBlank()) {
                map.put(declaredField.getName() + "Desc", desc);
                continue;
            }
            String dictNode = fieldDescAnnotation.dictNode();
            if (!dictNode.isBlank()) {
                map.put(declaredField.getName() + "Desc", dictFunction.desc(dictNode, o.toString()));
            }
        }
        return map;
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setUser(user);
        Map<String, Object> process = process(user, (dictNode, dictValue) -> dictNode + dictValue);
        System.out.println(process);
    }

    public static class User{

        @FieldDescAnnotation(desc = "我是张三")
        private String name;

        @FieldDescAnnotation(dictNode = "我是张三dictNode")
        private Integer age;
        @FieldDescAnnotation(desc = "我是张三")
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
