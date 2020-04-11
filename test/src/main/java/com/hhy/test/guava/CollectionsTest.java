package com.hhy.test.guava;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hhy
 * @date 2020/3/25 8:51
 * @version 1.0
 * @Description
 */
public class CollectionsTest {

    /**
     *不变集合
     * @return
     * @author hhy
     * @data 2020/3/25 9:28
     */
    public static void immutable(){
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");
        System.out.println(COLOR_NAMES.size());
        final List<String> list=new ArrayList<String>();
        list.add("aaa");
        ImmutableList<String>  immutableList= ImmutableList.copyOf(list);
        immutableList.forEach(l->{
            System.out.println(l);
        });
    }
   /**
   * multiset集合
   * @param null
   * @return
   * @author hhy
   * @data 2020/3/25 9:44
   */
    public static void multiset(){
        List<String> words = new ArrayList<String>(Arrays.asList("1","1","2"));
        //创建一个HashMultiset集合，并将words集合数据放入
        Multiset<String> wordMultiset = HashMultiset.create();
        wordMultiset.addAll(words);
        //将不同的元素放在一个集合set中
        for (String key : wordMultiset.elementSet()) {
            //查看指定元素的个数
            System.out.println(key + "-->" + wordMultiset.count(key));
        }
        wordMultiset.add("李四");
        wordMultiset.add("李四",5);
        for (String key : wordMultiset.elementSet()) {
            //查看指定元素的个数
            System.out.println(key + "-->" + wordMultiset.count(key));
        }
        //转list集合
        words=new ArrayList<String>(wordMultiset);
        System.out.println(words.size());
        wordMultiset.remove("李四",2);
        wordMultiset.removeAll(words);

        for (String key : wordMultiset.elementSet()) {
            //查看指定元素的个数
            System.out.println(key + "-->" + wordMultiset.count(key));
        }
        //设置集合中元素个数
        System.out.println(wordMultiset.setCount("李四", 1));
        for (String key : wordMultiset.elementSet()) {
            //查看指定元素的个数
            System.out.println(key + "-->" + wordMultiset.count(key));
        }
    }

    /***
     * multimap
     * @param
     * @return void
     * @author hhy
     * @data 2020/3/25 10:38
     */
    public static void multimap(){
        Multimap multimap=ArrayListMultimap.create();
        multimap.put("2","3");
        multimap.put("2","4");
        System.out.println(multimap.get("2"));
        multimap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
 /***
 * iterables
 * @return void
 * @author hhy
 * @data 2020/3/25 11:07
 */
    public static void list(){

        List countUp = Ints.asList(1, 2, 3, 4, 5);

        List countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}

        List<List> parts = Lists.partition(countUp, 1);//{{1,2}, {3,4}, {5}}

        System.out.println(countUp);
        System.out.println(countDown);
        System.out.println(parts);

    }






    public static void main(String[] args) {

        //multiset();

        //multimap();
        list();
    }


}
