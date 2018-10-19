package com.cipher.algorithm_visualization.J_Fractal_Drawing.sierpinski_triangle;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:55 2018/10/15
 */
public class TriangleFrame extends AlgoFrame {

    public TriangleFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        drawFractal(algoVisHelper, 0, getCanvasHeight(), getCanvasWidth(), 0);
    }

    private void drawFractal(AlgoVisHelper g, int aX, int aY, int side, int depth) {
        TriangleData data = (TriangleData) getData();
        int bX = aX + side;
        int bY = aY;
        int h = (int) (Math.sin(60.0 * Math.PI / 180.0) * side);
        int cX = aX + side / 2;
        int cY = aY - h;
        if (side <= 1) {
            g.setColor(AlgoVisHelper.Indigo);
            g.fillRectangle(aX, aY, 1, 1);
            return;
        }
        if (depth == data.depth) {
            g.setColor(AlgoVisHelper.Indigo);
            g.fillTriangle(aX, aY, bX, bY, cX, cY);
            return;
        }
        int abCenterX = (aX + bX) / 2;
        int abCenterY = (aY + bY) / 2;
        int acCenterX = (aX + cX) / 2;
        int acCenterY = (aY + cY) / 2;
        g.setColor(AlgoVisHelper.Indigo);
        drawFractal(g, aX, aY, side / 2, depth + 1);
        drawFractal(g, acCenterX, acCenterY, side / 2, depth + 1);
        drawFractal(g, abCenterX, abCenterY, side / 2, depth + 1);
    }


}
