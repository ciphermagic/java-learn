package com.cipher.data_structure.F_Set_and_Map.map;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:01 2018/11/7
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();

}
