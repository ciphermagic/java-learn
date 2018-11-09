package com.cipher.data_structure.F_Set_and_Map.set;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:49 2018/10/31
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
