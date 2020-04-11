package com.hhy.test.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author hhy
 * @date 2020/3/25 13:31
 * @version 1.0
 * @Description
 */
public class GuavaCacheTest {

    public void cache(){

        Cache<String,String> cache = CacheBuilder.newBuilder()
                         .maximumSize(2)
                         .expireAfterWrite(3, TimeUnit.SECONDS)
                         .build();


    }




    public static void main(String[] args) {

    }

}
