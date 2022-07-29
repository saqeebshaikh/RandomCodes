package com.sss.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CaffineCacheDemo {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, DummyGitResponse> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .maximumSize(1000)
                .build();

//        cache.put("Obj1", new DummyGitResponse("1"));
//        cache.put("Obj2", new DummyGitResponse("2"));
//        cache.put("Obj3", new DummyGitResponse("3"));
        for(int i = 1; i<100; i++) {
            cache.put("Obj"+i, new DummyGitResponse(""+i));
        }
        System.out.println("Cache size :: "+cache.estimatedSize());

        DummyGitResponse obj1 = cache.getIfPresent("Obj1");
        System.out.println("Obtained obj1 :: "+obj1);

        DummyGitResponse obj2 = cache.getIfPresent("Obj2");
        System.out.println("Obtained obj2 :: "+obj2);
        Thread.sleep(1000);
        obj1 = cache.getIfPresent("Obj1");
        System.out.println("Obtained obj1 :: "+ Objects.nonNull(obj1));
    }

    static private class DummyGitResponse {
        String text;

        public DummyGitResponse(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "DummyGitResponse { " +
                    "text=' " + text + '\'' +
                    '}';
        }
    }

//    public static void
}
