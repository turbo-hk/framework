package com.story.code.boot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
@Slf4j
@Configuration
@MapperScan({"com.story.code.infrastructure.tunnel.datatunnel.database.*"})
public class MybatisConfiguration {

}
