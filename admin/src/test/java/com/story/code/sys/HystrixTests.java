package com.story.code.sys;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/29 by Storys.Zhang
 */
public class HystrixTests {

    @Test
    public void testThread() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final int index = Integer.valueOf(i);
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    test(index);
                }
            }));
        }
        int i = 0;
        for (Thread thread : list) {
            thread.start();
            i++;
            System.out.println(i);
        }

        for (Thread thread : list) {
            thread.join();
        }
    }

    public void test(int i){
        long cityId = 1;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GetCityNameCommand getCityNameCommand = new GetCityNameCommand(cityId);
        // 获取本地内存(cityName)的代码会被信号量进行资源隔离
        String cityName = getCityNameCommand.execute();

        System.out.println(i+ "---" + cityName);
    }


    public static class GetCityNameCommand extends HystrixCommand<String> {

        private Long cityId;

        public GetCityNameCommand(Long cityId) {
            // 设置信号量隔离策略
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetCityNameGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));

            this.cityId = cityId;
        }

        @Override
        protected String run() {
            // 需要进行信号量隔离的代码
            return LocationCache.getCityName(cityId);
        }

        @Override
        protected String getFallback() {
            return "Fallback";
        }
    }

    public static class LocationCache {

        private static Map<Long, String> cityMap = new HashMap<>();

        static {
            cityMap.put(1L, "北京");
        }

        /**
         * 通过cityId 获取 cityName
         *
         * @param cityId 城市id
         * @return 城市名
         */
        public static String getCityName(Long cityId) {
            return cityMap.get(cityId);
        }
    }
}
