package com.cipher.algorithm_visualization.E_Sort.quick.two_ways;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:09 2018/9/19
 */
public class QuickSortFrame2Way extends AlgoFrame {

    public QuickSortFrame2Way(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        QuickSortData2Way sortData = (QuickSortData2Way) data;
        int w = getCanvasWidth() / sortData.N();
        for (int i = 0; i < sortData.N(); i++) {
            if (i >= sortData.l && i <= sortData.r) {
                algoVisHelper.setColor(AlgoVisHelper.Green);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Grey);
            }
            if (i == sortData.curPivot) {
                algoVisHelper.setColor(AlgoVisHelper.Indigo);
            }
            if (i >= sortData.l + 1 && i <= sortData.curL) {
                algoVisHelper.setColor(AlgoVisHelper.LightBlue);
            }
            if (i >= sortData.curR && i <= sortData.r) {
                algoVisHelper.setColor(AlgoVisHelper.LightBlue);
            }
            if (sortData.fixedPivots[i]) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            }
            algoVisHelper.fillRectangle(i * w, getCanvasHeight() - sortData.get(i), w - 1, sortData.get(i));
        }
    }

}
