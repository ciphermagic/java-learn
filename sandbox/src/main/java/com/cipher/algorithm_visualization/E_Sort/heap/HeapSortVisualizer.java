package com.cipher.algorithm_visualization.E_Sort.heap;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description: 堆排序
 * @Date: Created in 14:48 2018/9/21
 */
public class HeapSortVisualizer extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 20;

    public HeapSortVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new HeapSortData(N, sceneHeight);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new HeapSortFrame("Heap Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        HeapSortData sortData = (HeapSortData) data;
        setData(sortData.N());
        // 建堆
        for (int i = (sortData.N() - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(sortData.N(), i);
        }
        // 堆排序
        for (int i = sortData.N() - 1; i > 0; i--) {
            sortData.swap(0, i);
            shiftDown(i, 0);
            setData(i);
        }
        setData(0);
    }

    private void shiftDown(int n, int k) {
        HeapSortData data = (HeapSortData) getData();
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data.get(j + 1) > data.get(j)) {
                j += 1;
            }
            if (data.get(k) >= data.get(j)) {
                break;
            }
            data.swap(k, j);
            setData(data.heapIndex);
            k = j;
        }
    }

    private void setData(int heapIndex) {
        HeapSortData data = (HeapSortData) getData();
        data.heapIndex = heapIndex;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new HeapSortVisualizer(800, 300);
    }

}
