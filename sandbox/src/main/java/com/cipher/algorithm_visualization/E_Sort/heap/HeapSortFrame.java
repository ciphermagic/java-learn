package com.cipher.algorithm_visualization.E_Sort.heap;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:46 2018/9/21
 */
public class HeapSortFrame extends AlgoFrame {

    public HeapSortFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        HeapSortData sortData = (HeapSortData) data;
        int w = getCanvasWidth() / sortData.N();
        for (int i = 0; i < sortData.N(); i++) {
            if (i >= sortData.heapIndex) {
                algoVisHelper.setColor(AlgoVisHelper.Red);
            } else {
                algoVisHelper.setColor(AlgoVisHelper.Grey);
            }
            algoVisHelper.fillRectangle(i * w, getCanvasHeight() - sortData.get(i), w - 1, sortData.get(i));
        }
    }

}
