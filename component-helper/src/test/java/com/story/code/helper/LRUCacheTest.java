package com.story.code.helper;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/6/2 by Storys.Zhang
 */
public class LRUCacheTest {

    @Test
    public void test(){
        System.out.println(1000/0.75f);
        System.out.println(Math.ceil(1000/0.75f));

        LRUCache<Integer, Integer> lruCache = new LRUCache<>(10);
        for (int i = 0; i < 15; i++) {
            lruCache.put(i, i);
            if (i ==12){
                lruCache.put(3, 3);
            }
        }
    }

    public static class  LRUCache<K,V> extends LinkedHashMap {

        private final int CACHE_SIZE;

        public LRUCache(int cacheSize) {
            super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
            this.CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Entry eldest) {
            System.out.println("removeEldestEntry = " + super.size() + "---" + super.entrySet());
            return super.size() > CACHE_SIZE;
        }
    }

}
