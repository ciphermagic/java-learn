package com.cipher.data_structure.F_Set_and_Map.set;

import com.cipher.data_structure.C_Linked_List.LinkedList;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:42 2018/10/31
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
