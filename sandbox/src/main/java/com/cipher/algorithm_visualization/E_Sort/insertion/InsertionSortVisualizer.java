package com.cipher.algorithm_visualization.E_Sort.insertion;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:25 2018/9/17
 */
public class InsertionSortVisualizer extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 100;

    public InsertionSortVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new InsertionSortData(N, sceneHeight, InsertionSortData.Type.NearlyOrdered);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new InsertionSortFrame("Insertion Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        InsertionSortData sortData = (InsertionSortData) data;
        setData(-1, -1);
        for (int i = 0; i < sortData.N(); i++) {
            setData(i, i);
            for (int j = i; j > 0 && sortData.get(j) < sortData.get(j - 1); j--) {
                sortData.swap(j, j - 1);
                setData(i + 1, j - 1);
            }
        }
        setData(sortData.N(), -1);
    }

    private void setData(int orderedIndex, int currentIndex) {
        InsertionSortData data = (InsertionSortData) getData();
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new InsertionSortVisualizer(800, 300);
    }

}
