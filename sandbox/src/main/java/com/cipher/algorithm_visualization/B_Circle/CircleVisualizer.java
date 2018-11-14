package com.cipher.algorithm_visualization.B_Circle;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: CipherCui
 * @Description: 圆圈控制层
 * @Date: Created in 15:18 2018/9/10
 */
public class CircleVisualizer extends AlgoVisualizer {

    private static final int N = 10;
    private boolean isAnimated = true;

    public CircleVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        Circle[] circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R) + R);
            int y = (int) (Math.random() * (sceneHeight - 2 * R) + R);
            int vx = (int) (Math.random() * 11 - 5);
            int vy = (int) (Math.random() * 11 - 5);
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        return circles;
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        CircleFrame frame = new CircleFrame("Welcome", sceneWidth, sceneHeight);
        frame.addKeyListener(new AlgoKeyListener());
        frame.addMouseListener(new AlgoMouseListener());
        return frame;
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        Circle[] circles = (Circle[]) data;
        while (true) {
            frame.render(circles);
            AlgoVisHelper.pause(20);
            for (Circle c : circles) {
                if (isAnimated) {
                    c.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }
        }
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            if (event.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            Circle[] circles = (Circle[]) getData();
            for (Circle circle : circles) {
                if (circle.contain(event.getPoint())) {
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        new CircleVisualizer(sceneWidth, sceneHeight);
    }

}
