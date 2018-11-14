package com.cipher.algorithm_visualization.E_Sort.insertion;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:23 2018/9/17
 */
public class InsertionSortFrame extends AlgoFrame {

    public InsertionSortFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        InsertionSortData sortData = (InsertionSortData) data;
        int w = getCanvasWidth() / sortData.N();
        for (int i = 0; i < sortData.N(); i++) {
            if (i < sortData.orderedIndex) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Grey);
            }
            if (i == sortData.currentIndex) {
                algoVisHelper.setColor(AlgoVisHelper.LightBlue);
            }
            algoVisHelper.fillRectangle(i * w, getCanvasHeight() - sortData.get(i), w - 1, sortData.get(i));
        }
    }

}
