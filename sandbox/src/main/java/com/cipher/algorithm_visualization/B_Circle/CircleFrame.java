package com.cipher.algorithm_visualization.B_Circle;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

import java.awt.*;

/**
 * @Author: CipherCui
 * @Description: 圆圈窗口
 * @Date: Created in 11:13 2018/9/10
 */
public class CircleFrame extends AlgoFrame {

    public CircleFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        algoVisHelper.setStrokeWidth(1);
        algoVisHelper.setColor(Color.RED);
        Circle[] circles = (Circle[]) data;
        for (Circle c : circles) {
            if (c.isFilled) {
                algoVisHelper.fillCircle(c.x, c.y, c.getR());
            } else {
                algoVisHelper.strokeCircle(c.x, c.y, c.getR());
            }
        }
    }


}
