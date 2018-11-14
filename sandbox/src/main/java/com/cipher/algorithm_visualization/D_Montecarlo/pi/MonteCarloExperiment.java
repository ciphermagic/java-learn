package com.cipher.algorithm_visualization.D_Montecarlo.pi;

import java.awt.*;

/**
 * @Author: CipherCui
 * @Description: 不需要可视化的蒙特卡洛模拟 - 计算 pi 值
 * @Date: Created in 15:49 2018/9/13
 */
public class MonteCarloExperiment {

    public static void main(String[] args) {
        int squareSide = 800;
        int N = 10000000;
        Circle circle = new Circle(squareSide / 2, squareSide / 2, squareSide / 2);
        MonteCarloPiData piData = new MonteCarloPiData(circle);
        for (int i = 0; i < N; i++) {
            if (i % (N / 100) == 0) {
                System.out.println(piData.estimatePi());
            }
            int x = (int) (Math.random() * squareSide);
            int y = (int) (Math.random() * squareSide);
            piData.addPoint(new Point(x, y));
        }
    }

}
