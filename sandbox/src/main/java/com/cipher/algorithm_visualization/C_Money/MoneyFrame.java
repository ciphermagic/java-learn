package com.cipher.algorithm_visualization.C_Money;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:28 2018/9/11
 */
public class MoneyFrame extends AlgoFrame {

    public MoneyFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        int[] money = (int[]) data;
        int w = getCanvasWidth() / money.length;
        for (int i = 0; i < money.length; i++) {
            if (money[i] > 0) {
                algoVisHelper.setColor(AlgoVisHelper.Blue);
                algoVisHelper.fillRectangle(i * w, getCanvasHeight() / 2 - money[i], w - 1, money[i]);
            } else if (money[i] < 0) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
                algoVisHelper.fillRectangle(i * w, getCanvasHeight() / 2, w - 1, -money[i]);
            }
        }
    }

}
