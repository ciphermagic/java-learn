package com.cipher.algorithm_visualization.D_Montecarlo.pi;

import java.awt.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:21 2018/9/13
 */
public class Circle {

    private int x, y, r;

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getR(){ return r; }

    public boolean contain(Point p){
        return Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) <= r*r;
    }

}
