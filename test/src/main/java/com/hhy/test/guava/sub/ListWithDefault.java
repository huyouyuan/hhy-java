package com.hhy.test.guava.sub;

import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hhy 自定义List  元素null替换为E
 * @date 2020/3/25 11:30
 * @version 1.0
 * @Description
 */
public class ListWithDefault<E> extends ForwardingList<E> {
    final E defaultValue;
    final List<E> delegate;
    ListWithDefault(List<E> delegate, E defaultValue) {
        this.delegate = delegate;
        this.defaultValue = defaultValue;
    }
    @Override
    protected List<E> delegate() {
        return delegate;
    }
    @Override
    public E get(int index) {
        E v = super.get(index);
        return (v == null ? defaultValue : v);
    }
    @Override
    public Iterator<E> iterator() {
        final Iterator<E> iter = super.iterator();
        return new ForwardingIterator<E>() {
            @Override
            protected Iterator<E> delegate() {
                return iter;
            }
            @Override
            public E next() {
                E v = super.next();
                return (v == null ? defaultValue : v);
            }
        };
    }

    public static void main(String[] args) {
        List<String> names = new ListWithDefault<String>(
                Arrays.asList("Alice", null, "Bob", "Carol", null),
                "UNKNOWN"
        );
        names.forEach(v->{
            System.out.println(v);
        });


    }


}
