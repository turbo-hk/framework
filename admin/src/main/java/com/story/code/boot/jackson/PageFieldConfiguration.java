package com.story.code.boot.jackson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置分页需要的参数名称
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "page.field")
public class PageFieldConfiguration {

    /**
     * 当前页
     */
    private String current = "current";

    /**
     * 每页条数
     */
    private String pageSize = "pageSize";

    /**
     * 总条数
     */
    private String total = "total";

    /**
     * 数据列表
     */
    private String data = "data";

}
