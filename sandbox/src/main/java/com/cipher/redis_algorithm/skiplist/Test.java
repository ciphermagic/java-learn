package com.cipher.redis_algorithm.skiplist;

public class Test {

    public static void main(String[] args) {
        Zskiplist zsl = Zskiplist.zslCreate();
        ZskiplistOp.zslInsert(zsl, 31, "C");
        ZskiplistOp.zslInsert(zsl, 41, "D");
        ZskiplistOp.zslInsert(zsl, 21, "B");
        ZskiplistOp.zslInsert(zsl, 1, "A");
        System.out.println();
    }

}
