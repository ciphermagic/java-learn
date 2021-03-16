package com.cipher.redis_algorithm.skiplist;

import static com.cipher.redis_algorithm.skiplist.Constant.ZSKIPLIST_MAXLEVEL;

/**
 * 跳跃表结构，用于管理节点
 *
 * @author cipher
 */
public class Zskiplist {

    /**
     * 指向跳跃表头节点，
     * 头节点是一个特殊节点，它的 level 数组元素个数固定为 64。
     * 头节点的 ele 为空，score 为 0
     * 头节点不计入跳跃表的总长度
     */
    private ZskiplistNode header;

    /**
     * 指向跳跃表尾节点，用于从后向前遍历
     */
    private ZskiplistNode tail;

    /**
     * 跳跃表的长度，除头结点外，所有节点的个数
     */
    private int length;

    /**
     * 跳跃表的高度，即跳跃表所有节点中层高最高的那个节点的层高
     */
    private int level;

    /**
     * 创建跳跃表
     *
     * @return 跳跃表结构
     */
    public static Zskiplist zslCreate() {
        Zskiplist zsl = new Zskiplist();

        // 跳跃表层高初始化为 1，长度初始化为 0
        zsl.level = 1;
        zsl.length = 0;

        // 创建头节点，头节点不存储有序集合的 member 信息
        zsl.header = ZskiplistNode.zslCreateNode(ZSKIPLIST_MAXLEVEL, 0, null);

        // 头节点的 level 数组的每项 forward 都为 null，span 值都为 0
        for (int j = 0; j < ZSKIPLIST_MAXLEVEL; j++) {
            zsl.header.getLevel()[j].setForward(null);
            zsl.header.getLevel()[j].setSpan(0);
        }

        // 头节点的后退指针为 null
        zsl.header.setBackward(null);

        // 尾节点指向 null
        zsl.tail = null;
        return zsl;
    }

    public ZskiplistNode getHeader() {
        return header;
    }

    public void setHeader(ZskiplistNode header) {
        this.header = header;
    }

    public ZskiplistNode getTail() {
        return tail;
    }

    public void setTail(ZskiplistNode tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
