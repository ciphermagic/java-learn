package com.cipher.algorithm_visualization.A_Base;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: CipherCui
 * @Description: 抽象自定义窗口
 * @Date: Created in 11:13 2018/9/10
 */
public abstract class AlgoFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        AlgoCanvas canvas = new AlgoCanvas();
        this.setContentPane(canvas);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void render(Object data) {
        this.data = data;
        this.repaint();
    }

    /**
     * 绘制画布
     *
     * @param algoVisHelper
     * @param data
     */
    public abstract void paint(AlgoVisHelper algoVisHelper, Object data);

    private class AlgoCanvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            AlgoVisHelper algoVisHelper = AlgoVisHelper.getInstance(g);
            if (data != null) {
                AlgoFrame.this.paint(algoVisHelper, data);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}
