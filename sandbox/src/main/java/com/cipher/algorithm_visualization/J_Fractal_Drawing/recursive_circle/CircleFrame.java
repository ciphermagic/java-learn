package com.cipher.algorithm_visualization.J_Fractal_Drawing.recursive_circle;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:48 2018/10/15
 */
public class CircleFrame extends AlgoFrame {

    public CircleFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object obj) {
        CircleData data = (CircleData) obj;
        drawCircle(algoVisHelper, data.getStartX(), data.getStartY(), data.getStartR(), 0);
    }

    private void drawCircle(AlgoVisHelper g, int x, int y, int r, int depth) {
        CircleData data = (CircleData) getData();
        if (depth == data.getDepth() || r < 1) {
            return;
        }
        if (depth % 2 == 0) {
            g.setColor(AlgoVisHelper.Red);
        } else {
            g.setColor(AlgoVisHelper.LightBlue);
        }
        g.fillCircle(x, y, r);
        drawCircle(g, x, y, r - data.getStep(), depth + 1);
    }

}
