package com.story.code;

import com.story.code.boot.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 项目启动入口
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/1 by Storys.Zhang
 */
@SpringBootApplication
@Import(SpringContextHolder.class)
@ComponentScan(basePackages = "com.story.code.**")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
