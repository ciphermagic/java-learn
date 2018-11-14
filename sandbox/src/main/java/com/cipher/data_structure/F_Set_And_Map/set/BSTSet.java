package com.cipher.data_structure.F_Set_and_Map.set;

import com.cipher.data_structure.E_Binary_Search_Tree.BST;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:53 2018/10/31
 */
public class BSTSet<E extends Comparable> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

}
