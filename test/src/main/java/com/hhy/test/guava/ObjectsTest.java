package com.hhy.test.guava;

import com.google.common.base.Objects;

/**
 * @author hhy
 * @date 2020/3/24 20:43
 * @version 1.0
 * @Description
 */
public class ObjectsTest {

    public static void main(String[] args) {
        Objects.equal(null, "a");
        System.out.println(Objects.hashCode("2312","345"));

    }


}



