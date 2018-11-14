package com.cipher.algorithm_visualization.J_Fractal_Drawing.vicsek_fractal;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/10/15
 */
public class VicsekFrame2 extends AlgoFrame {

    public VicsekFrame2(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object obj) {
        VicsekData data = (VicsekData) obj;
        drawFractal(algoVisHelper, 0, 0, getCanvasWidth(), getCanvasHeight(), 0);
    }

    private void drawFractal(AlgoVisHelper g, int x, int y, int w, int h, int depth) {
        VicsekData data = (VicsekData) getData();
        if (depth == data.depth) {
            g.setColor(AlgoVisHelper.Indigo);
            g.fillRectangle(x, y, w, h);
            return;
        }
        if (w <= 1 || h <= 1) {
            g.setColor(AlgoVisHelper.Indigo);
            g.fillRectangle(x, y, Math.max(w, 1), Math.max(h, 1));
            return;
        }
        int w_3 = w / 3;
        int h_3 = h / 3;
        drawFractal(g, x + w_3, y, w_3, h_3, depth + 1);
        drawFractal(g, x, y + h_3, w_3, h_3, depth + 1);
        drawFractal(g, x + w_3, y + h_3, w_3, h_3, depth + 1);
        drawFractal(g, x + 2 * w_3, y + h_3, w_3, h_3, depth + 1);
        drawFractal(g, x + w_3, y + 2 * h_3, w_3, h_3, depth + 1);
    }

}
