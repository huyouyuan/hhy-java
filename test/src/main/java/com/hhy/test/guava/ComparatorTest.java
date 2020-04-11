package com.hhy.test.guava;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author hhy
 * @date 2020/3/24 19:47
 * @version 1.0
 * @Description
 */
public class ComparatorTest {


    public static void main(String[] args) {

        //构造一个比较器，先根据字符串长度排序，再按照字典序排序，null值置前
        Ordering<String> ordering = Ordering.natural()
                .onResultOf((String str) -> {
                    //使用Optional处理null值
                    return Optional.fromNullable(str).or("").length();
                }).compound(Ordering.natural().nullsFirst()); //compound用于合并两个Ordering


        Ordering<String> ordering1 = Ordering.natural().nullsFirst();


        ArrayList<String> names = Lists.newArrayList("Ram", "Shyam", "Mohan", "Sohan",
                "Ramesh", "Suresh", "Naresh", "Mahesh", null, "", "Vikas", "Deepak");
        Collections.sort(names, ordering1);
        System.out.println(names);

        System.out.println( ordering.sortedCopy(names));




        //natural()	对可排序类型做自然排序，如数字按大小，日期按先后排序
       // usingToString()	按对象的字符串形式做字典排序[lexicographical ordering]
       // from(Comparator)	把给定的Comparator转化为排序器


       // reverse()	获取语义相反的排序器
       // nullsFirst()	使用当前排序器，但额外把null值排到最前面。
      //  nullsLast()	使用当前排序器，但额外把null值排到最后面。
      //  compound(Comparator)	合成另一个比较器，以处理当前排序器中的相等情况。
       // lexicographical()	基于处理类型T的排序器，返回该类型的可迭代对象Iterable<T>的排序器。
      //  onResultOf(Function)	对集合中元素调用Function，再按返回值用当前排序器排序。
    }
}