package com.cipher.algorithm_visualization.E_Sort.quick.with_random_pivot;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:43 2018/9/15
 */
public class QuickSortVisualizerRandom extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 20;

    public QuickSortVisualizerRandom(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new QuickSortDataRandom(N, sceneHeight, QuickSortDataRandom.Type.Identical);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new QuickSortFrameRandom("Quick Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        QuickSortDataRandom sortData = (QuickSortDataRandom) getData();
        setData(-1, -1, -1, -1, -1);
        quickSort(0, sortData.N() - 1);
        setData(-1, -1, -1, -1, -1);
    }

    private void quickSort(int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            setData(l, r, l, -1, -1);
            return;
        }
        setData(l, r, -1, -1, -1);
        int p = partition(l, r);
        quickSort(l, p - 1);
        quickSort(p + 1, r);
    }

    private int partition(int l, int r) {
        QuickSortDataRandom sortData = (QuickSortDataRandom) getData();
        int p = (int) (Math.random() * (r - l + 1) + l);
        setData(l, r, -1, p, -1);
        sortData.swap(l, p);
        int v = sortData.get(l);
        setData(l, r, -1, l, -1);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            setData(l, r, -1, l, i);
            if (sortData.get(i) < v) {
                j++;
                sortData.swap(j, i);
                setData(l, r, -1, l, i);
            }
        }
        sortData.swap(l, j);
        setData(l, r, j, -1, -1);
        return j;
    }

    private void setData(int l, int r, int fixedPivot, int curPivot, int curElement) {
        QuickSortDataRandom data = (QuickSortDataRandom) getData();
        data.l = l;
        data.r = r;
        data.curPivot = curPivot;
        data.curElement = curElement;
        if (fixedPivot != -1) {
            data.fixedPivot[fixedPivot] = true;
        }
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new QuickSortVisualizerRandom(800, 300);
    }

}
