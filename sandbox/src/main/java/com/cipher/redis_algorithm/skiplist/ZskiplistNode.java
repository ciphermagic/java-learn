package com.cipher.redis_algorithm.skiplist;

/**
 * 跳跃表节点
 * 跳跃表由多个节点构成，每个节点由多个层 {@link ZskiplistLevel} 构成
 *
 * @author cipher
 */
public class ZskiplistNode {

    /**
     * 用于存储字符串类型的数据，
     * 即有序集合的 member 信息
     */
    private String ele;

    /**
     * 用于存储排序的分值，
     * 所有节点的分值是按从小到大排序的，
     * 分值相同时，按 {@link ZskiplistNode#ele} 的字典序进行排序
     */
    private double score;

    /**
     * 后退指针，只能指向当前节点最底层的前一个节点，
     * 头节点和第一个节点的 backward 指向 null，
     * 从后向前遍历跳跃表时使用
     */
    private ZskiplistNode backward;

    /**
     * 用于存储当前节点的层，数组长度为 1~64 的随机值，
     * 值越大概率越低
     */
    private ZskiplistLevel[] level;

    /**
     * 创建跳跃表节点时，待创建节点的层高，分值，member 等都已确定
     *
     * @param level 节点层高
     * @param score 分值
     * @param ele   元素值
     * @return 跳跃表节点
     */
    public static ZskiplistNode zslCreateNode(int level, double score, String ele) {
        ZskiplistNode node = new ZskiplistNode();
        node.ele = ele;
        node.score = score;
        node.level = new ZskiplistLevel[level];
        for (int i = 0; i < node.level.length; i++) {
            node.level[i] = new ZskiplistLevel();
        }
        return node;
    }

    public String getEle() {
        return ele;
    }

    public void setEle(String ele) {
        this.ele = ele;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ZskiplistLevel[] getLevel() {
        return level;
    }

    public void setLevel(ZskiplistLevel[] level) {
        this.level = level;
    }

    public ZskiplistNode getBackward() {
        return backward;
    }

    public void setBackward(ZskiplistNode backward) {
        this.backward = backward;
    }

    /**
     * 节点中的层
     */
    public static class ZskiplistLevel {

        /**
         * 指向本层下一个节点，尾节点指向 null
         */
        private ZskiplistNode forward;

        /**
         * forward 指向节点与本节点之间的元素个数。
         * span 值越大，跳过的节点个数越多
         */
        private int span;

        public ZskiplistNode getForward() {
            return forward;
        }

        public void setForward(ZskiplistNode forward) {
            this.forward = forward;
        }

        public int getSpan() {
            return span;
        }

        public void setSpan(int span) {
            this.span = span;
        }
    }

}
