package com.cipher.algorithm_visualization.E_Sort.merge;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:02 2018/9/18
 */
public class MergeSortFrame extends AlgoFrame {

    public MergeSortFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        MergeSortData sortData = (MergeSortData) data;
        int w = getCanvasWidth() / sortData.N();
        for (int i = 0; i < sortData.N(); i++) {
            if (i >= sortData.l && i <= sortData.r) {
                algoVisHelper.setColor(AlgoVisHelper.Green);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Grey);
            }
            if (i >= sortData.l && i <= sortData.mergeIndex) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            }
            algoVisHelper.fillRectangle(i * w, getCanvasHeight() - sortData.get(i), w - 1, sortData.get(i));
        }
    }

}
