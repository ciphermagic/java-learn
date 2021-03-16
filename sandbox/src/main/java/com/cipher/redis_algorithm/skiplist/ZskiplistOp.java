package com.cipher.redis_algorithm.skiplist;

import java.math.BigDecimal;
import java.util.Random;

import static com.cipher.redis_algorithm.skiplist.Constant.ZSKIPLIST_MAXLEVEL;
import static com.cipher.redis_algorithm.skiplist.Constant.ZSKIPLIST_P;
import static com.cipher.redis_algorithm.skiplist.ZskiplistNode.zslCreateNode;

/**
 * 跳跃表操作
 *
 * @author cipher
 */
public class ZskiplistOp {

    /**
     * 插入节点，共需要 4 个 步骤：
     * ① 收集需要更新的节点与步长信息；
     * ② 获取随机层高，补全需要更新的节点
     * ③ 创建并分层插入节点，同时更新同层前一节点步长信息；
     * ④ 更新新增节点未涉及层节点的步长信息，以及调整 backward
     *
     * @param zsl   跳跃表结构
     * @param score 待插入节点的分值
     * @param ele   待插入节点的元素
     * @return 跳跃表的头节点
     */
    public static ZskiplistNode zslInsert(Zskiplist zsl, double score, String ele) {

        // 插入节点时，需要更新被插入节点每层的前一个节点。由于每层更新的节点不一样，
        // 所以将插入新增节点后每层受影响节点存在 update 数组中，update[i]为第 i + 1 层会受影响节点
        ZskiplistNode[] update = new ZskiplistNode[ZSKIPLIST_MAXLEVEL];

        // 将每层头节点与会受影响的节点中间存在节点数存在 rank 数组中，rank[i] 为头节点与第 i + 1 层会受影响节点中间存在的节点数，
        // 在更新 update[i] 的 span 和设置新插入节点的 span 时用到
        Integer[] rank = new Integer[ZSKIPLIST_MAXLEVEL];

        // 第一步，收集需要更新的节点与步长信息
        ZskiplistNode x = zsl.getHeader();
        // 从最高层开始向下一层一层地遍历
        for (int i = zsl.getLevel() - 1; i >= 0; i--) {

            // 第一次 for 循环的遍历，即 i==zsl.getLevel()-1 时步长从 0 开始计算，
            // 后序遍历的步长需要在上一层的基础上开始计算，因此 rank[i] 初始为 rank[i+1]
            rank[i] = i == (zsl.getLevel() - 1) ? 0 : rank[i + 1];

            // 这里 white 循环是同一层中的节点遍历，为了找到本层中新插入节点的前一个节点，
            // 需要满足以下条件：
            // 1、本层指向的下一个节点不为空；
            // 2、本层指向的下一个节点的分值小于新插入节点的分值，分值相同时用元素值来比较
            while (x.getLevel()[i].getForward() != null &&
                    (x.getLevel()[i].getForward().getScore() < score ||
                            (x.getLevel()[i].getForward().getScore() == score &&
                                    x.getLevel()[i].getForward().getEle().compareTo(ele) < 0))) {
                // 步长累加
                rank[i] += x.getLevel()[i].getSpan();
                // x 移动到下一个节点
                x = x.getLevel()[i].getForward();
            }

            // 记录本层中需要修改的节点，即新插入节点的前一个节点
            update[i] = x;
        }

        // 第二步，获取随机层高，补全需要更新的节点
        // 获取随机层高
        int level = zslRandomLevel();
        // 如果新插入节点的层高大于跳跃表的原高度，那么高出的这几层的头节点也是需要更新信息的
        if (level > zsl.getLevel()) {
            // 从高出的层数开始向上遍历
            for (int i = zsl.getLevel(); i < level; i++) {

                // 因为是高出的层，所以只有头节点需要更新，步长自然为 0
                rank[i] = 0;
                update[i] = zsl.getHeader();

                // 先将 span 值赋值为跳跃表的总长度，方便后序计算
                // 注意这时的 span 不是最终值，在插入节点后会重新计算赋值
                update[i].getLevel()[i].setSpan(zsl.getLength());
            }
            // 因为新插入节点的层高大于跳跃表的原高度，所以更新跳跃表的高度
            zsl.setLevel(level);
        }

        // 第三步，创建并分层插入节点，同时更新同层前一节点步长信息
        ZskiplistNode newNode = zslCreateNode(level, score, ele);
        // 从第 0 层开始，向上一层一层地遍历
        for (int i = 0; i < level; i++) {

            // 本层中插入节点
            // 相当于链表的插入操作， A -> B 更新为 A -> newNode -> B
            newNode.getLevel()[i].setForward(update[i].getLevel()[i].getForward());
            update[i].getLevel()[i].setForward(newNode);

            /**
             * 说明：
             * 步长的赋值操作有点难懂，稍微解释一下，因为跳跃表的每个节点都至少有一层（这是由 zslRandomLevel() 方法保证的），
             * 因此跳跃表的第一层是一个普通链表，一个节点挨着一个节点，没有跨过任何节点。
             * update[0] 表示第一层需要修改的节点，这个节点必定为第一层中紧挨着新插入节点的前一个节点，
             * rank[0] 就是紧挨着新插入节点的前一个节点到头节点的距离。
             */

            // 设置新增节点步长信息
            // 因为 rank[0] 表示紧挨着新插入节点的前一个节点到头节点的距离（见上面的说明），
            // 所以 (rank[0] - rank[i]) 表示 update[i] 节点到紧挨着新插入节点的前一个节点的距离，
            // update[i] 的 span 值表示原跳跃表中 update[i] 到下一节点的距离，
            // 这是 update[i] 和 update[i] 的下一节点之间要插入新增的节点，update[i] -> next 更新为 update[i] -> newNode -> next
            // 所以新增节点到下一节点的距离为 update[i].span - (rank[0] - rank[i])
            newNode.getLevel()[i].setSpan(update[i].getLevel()[i].getSpan() - ((rank[0] - rank[i])));

            // 更新本层中新插入节点的前一个节点，即 update[i] 的步长信息，
            // 因为 rank[0] 表示紧挨着新插入节点的前一个节点到头节点的距离（见上面的说明），
            // 所以 (rank[0] - rank[i]) 表示 update[i] 节点到紧挨着新插入节点的前一个节点的距离，
            // 因此这个距离加 1 就是 update[i] 节点到新插入节点的距离
            /**
             *             rank[i]    (rank[0]-rank[i])
             *           /         \    /          \
             *  Li: head -----------> A ------------
             *   .
             *   .                 rank[0]
             *   .       /                          \     1
             *   .      /                            \  /   \
             *  L0: head -----------> A ------------> B -----> newNode
             */
            update[i].getLevel()[i].setSpan((rank[0] - rank[i]) + 1);
        }

        // 更新新增节点未涉及层节点的步长信息，以及调整 backward
        // 能进入此循环，表示新插入节点的层高小于跳跃表原高度，
        // 那么高于新插入节点层高的那些需要更新的节点，步长需要加 1 (因为在它和它的下一个节点之间插入了新增节点)
        for (int i = level; i < zsl.getLevel(); i++) {
            int span = update[i].getLevel()[i].getSpan();
            update[i].getLevel()[i].setSpan(span + 1);
        }

        // 调整 backward
        // update[0] 表示紧挨着新插入节点的前一个节点，每个节点的后退指针只有一个，与层数无关
        // 所以新插入节点的后退指针指向 update[0]，如果 update[0] 是头节点，则指向 null
        newNode.setBackward((update[0] == zsl.getHeader()) ? null : update[0]);
        // 如果新插入节点的下一个节点不是空，表示新插入节点不是最后一个节点，
        // 那么需要更新新插入节点的下一个节点的后退指针，指向新插入节点
        if (newNode.getLevel()[0].getForward() != null) {
            newNode.getLevel()[0].getForward().setBackward(newNode);
        }
        // 如果新插入节点是最后一个节点，则需要更新跳跃表的尾节点为新插入节点
        else {
            zsl.setTail(newNode);
        }
        // 插入节点后，跳跃表的长度加 1
        zsl.setLength(zsl.getLength() + 1);
        return newNode;
    }

    /**
     * Redis 通过此函数随机生成一个 1~64 的值，作为新建节点的高度，
     * 值越大出现的概率越低，节点层高确定之后便不会再修改
     *
     * @return 层高
     */
    public static int zslRandomLevel() {
        int level = 1;
        Random random = new Random();
        while (round(random.nextFloat()) < ZSKIPLIST_P) {
            level += 1;
        }
        return Math.min(level, ZSKIPLIST_MAXLEVEL);
    }

    /**
     * 保留小数点两位
     * 注意：redis 中是使用位运算来比较大小，这里为了便于理解，改成直接比较小数
     *
     * @param num 原值
     * @return 保留小数点两位后的值
     */
    private static float round(float num) {
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

}
