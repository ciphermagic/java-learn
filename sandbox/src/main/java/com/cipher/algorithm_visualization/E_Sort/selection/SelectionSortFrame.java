package com.cipher.algorithm_visualization.E_Sort.selection;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:37 2018/9/15
 */
public class SelectionSortFrame extends AlgoFrame {

    public SelectionSortFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        SelectionSortData sortData = (SelectionSortData) data;
        int w = getCanvasWidth() / sortData.N();
        for (int i = 0; i < sortData.N(); i++) {
            if (i < sortData.orderedIndex) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Grey);
            }
            if (i == sortData.currentCompareIndex) {
                algoVisHelper.setColor(AlgoVisHelper.LightBlue);
            }
            if (i == sortData.currentMinIndex) {
                algoVisHelper.setColor(AlgoVisHelper.Indigo);
            }
            algoVisHelper.fillRectangle(i * w, getCanvasHeight() - sortData.get(i), w - 1, sortData.get(i));
        }
    }

}
