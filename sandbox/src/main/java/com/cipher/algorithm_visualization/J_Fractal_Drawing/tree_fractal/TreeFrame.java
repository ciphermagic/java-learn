package com.cipher.algorithm_visualization.J_Fractal_Drawing.tree_fractal;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/10/15
 */
public class TreeFrame extends AlgoFrame {

    public TreeFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper g, Object obj) {
        drawFractal(g, getCanvasWidth() / 2, getCanvasHeight(), getCanvasHeight(), 0, 0);
    }

    private void drawFractal(AlgoVisHelper g, double x1, double y1, double side, double angle, int depth) {
        TreeData data = (TreeData) getData();
        if (side <= 0) {
            return;
        }
        if (depth == data.depth) {
            double x2 = x1 - Math.sin(angle * Math.PI / 180.0) * side;
            double y2 = y1 - Math.cos(angle * Math.PI / 180.0) * side;
            g.setColor(AlgoVisHelper.Indigo);
            g.drawLine(x1, y1, x2, y2);
            return;
        }

        double s = side / 2;
        double x2 = x1 - Math.sin(angle * Math.PI / 180.0) * s;
        double y2 = y1 - Math.cos(angle * Math.PI / 180.0) * s;
        g.setColor(AlgoVisHelper.Indigo);
        g.drawLine(x1, y1, x2, y2);

        drawFractal(g, x2, y2, s, angle + data.splitAngle / 2, depth + 1);
        drawFractal(g, x2, y2, s, angle - data.splitAngle / 2, depth + 1);
    }

}
