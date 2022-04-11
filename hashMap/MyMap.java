package org.hashMap;

public interface MyMap<K,V> {
    int size();
    boolean isEmpty();
    //根据key获取元素
    Object get(Object key);
    //添加元素
    Object put(Object key,Object value);
    interface Entry<k,v>{
        k getkey();
        v getValue();
    }
}
