package com.sss.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class TimedMapCacheDemo {
    private static final Map<String, Timer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        cacheString("1");
        printData();
        Thread.sleep(10000);
        cacheString("2");
        printData();
        Thread.sleep(20000);
        printData();
        System.out.println("main() ends");
    }

    private static void cacheString(String data) {
        final Date date = Date.from(LocalDateTime.now().plusSeconds(30).atZone(ZoneId.systemDefault()).toInstant());
        Timer timer = new Timer();
        timer.schedule(new CustomTimedTask(cache, data), date);
        cache.put(data, timer);
    }

    private static void printData() {
//        if(cache.containsKey("1"))
//            System.out.println("1 found");
//        else
//            System.out.println("1 not found");
            System.out.println("Cache is :: "+cache);
    }
}

class CustomTimedTask extends TimerTask {
    Map<String, Timer> timedCache;
    String key;


    public CustomTimedTask(Map<String, Timer> timedCache, String key) {
        this.timedCache = timedCache;
        this.key = key;
    }

    @Override
    public void run() {
        System.out.println("Removing "+key);
        final Timer removedTimer = timedCache.remove(key);
        removedTimer.cancel();
        System.out.println("Cache After removing "+key+" :: "+timedCache);
    }
}
