package com.story.code.sys;

import com.story.code.common.ApiResponseVO;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/1 by Storys.Zhang
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@RunWith(SpringRunner.class)
public class MenuMockMvcTests {

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = WebClient.create("http://127.0.0.1:8080");

    }

    @Test
    public void page() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", 100);
        Mono<ApiResponseVO> response = this.webClient.post().uri("/sys/menu/page").body(BodyInserters.fromValue(map)).accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToMono(ApiResponseVO.class);

        ApiResponseVO vo = response.block();

        System.out.println(vo);
    }

}
