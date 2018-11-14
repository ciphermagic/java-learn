package com.cipher.algorithm_visualization.E_Sort.selection;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:43 2018/9/15
 */
public class SelectionSortVisualizer extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 10;

    public SelectionSortVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new SelectionSortData(N, sceneHeight);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new SelectionSortFrame("Selection Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        SelectionSortData sortData = (SelectionSortData) data;
        setData(-1, -1, -1);
        for (int i = 0; i < sortData.N(); i++) {
            int min = i;
            setData(i, -1, min);
            for (int j = i + 1; j < sortData.N(); j++) {
                setData(i, j, min);
                if (sortData.get(j) < sortData.get(min)) {
                    min = j;
                    setData(i, j, min);
                }
            }
            sortData.swap(i, min);
            setData(i + 1, -1, -1);
        }
        setData(sortData.N(), -1, -1);
    }

    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex) {
        SelectionSortData data = (SelectionSortData) getData();
        data.orderedIndex = orderedIndex;
        data.currentMinIndex = currentMinIndex;
        data.currentCompareIndex = currentCompareIndex;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new SelectionSortVisualizer(800, 300);
    }

}
