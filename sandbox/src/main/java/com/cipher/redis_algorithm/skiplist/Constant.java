package com.cipher.redis_algorithm.skiplist;

/**
 * 跳跃表用到的各种常量
 *
 * @author cipher
 */
public class Constant {

    /**
     * 节点层高最大值
     */
    public static final int ZSKIPLIST_MAXLEVEL = 64;

    /**
     * 控制节点层高的概率，当 p=0.25 时，跳跃表的期望层高是 1/(1-0.25)≈1.33
     */
    public static final float ZSKIPLIST_P = 0.25f;

}
