package com.cipher.algoapi.base;

import java.awt.*;
import java.awt.event.*;

/**
 * @Author: CipherCui
 * @Description: 抽象控制层
 * @Date: Created in 15:18 2018/9/10
 */
public abstract class AlgoVisualizer {

    private Object data;
    private AlgoFrame frame;

    /**
     * 初始化数据
     *
     * @param sceneWidth
     * @param sceneHeight
     * @return
     */
    public abstract Object initData(int sceneWidth, int sceneHeight);

    /**
     * 初始化窗口 frame
     *
     * @return
     */
    public abstract AlgoFrame initFrame(int sceneWidth, int sceneHeight);

    /**
     * 动画逻辑
     *
     * @param data
     * @param frame
     */
    public abstract void run(Object data, AlgoFrame frame);

    public AlgoVisualizer(int sceneWidth, int sceneHeight) {
        // 数据
        data = initData(sceneWidth, sceneHeight);
        // 视图
        EventQueue.invokeLater(() -> {
            frame = initFrame(sceneWidth, sceneHeight);
            // 动画逻辑
            new Thread(() -> run(data, frame)).start();
        });
    }

    public Object getData() {
        return data;
    }
}
