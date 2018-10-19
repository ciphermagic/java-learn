package com.cipher.algorithm_visualization.D_Montecarlo.pi;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

import java.awt.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:20 2018/9/13
 */
public class PiFrame extends AlgoFrame {

    public PiFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        MonteCarloPiData piData = (MonteCarloPiData) data;
        Circle circle = piData.getCircle();
        algoVisHelper.setStrokeWidth(3);
        algoVisHelper.setColor(AlgoVisHelper.Blue);
        algoVisHelper.strokeCircle(circle.getX(), circle.getY(), circle.getR());
        for (int i = 0; i < piData.getPointsNumber(); i++) {
            Point p = piData.getPoint(i);
            if (circle.contain(p)) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Green);
            }
            algoVisHelper.fillCircle((int) p.getX(), (int) p.getY(), 3);
        }
        algoVisHelper.setColor(AlgoVisHelper.Black);
        algoVisHelper.drawText(String.valueOf(piData.estimatePi()), circle.getX(), circle.getY());
    }

}
