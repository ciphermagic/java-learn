package com.cipher.algorithm_visualization.J_Fractal_Drawing.recursive_circle;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:41 2018/10/15
 */
public class CircleData {

    private int startX, startY;
    private int startR;
    private int depth;
    private int step;

    public CircleData(int x, int y, int r, int d, int step) {
        this.startX = x;
        this.startY = y;
        this.startR = r;
        this.depth = d;
        this.step = step;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getStartR() {
        return startR;
    }

    public int getDepth() {
        return depth;
    }

    public int getStep() {
        return step;
    }
}
