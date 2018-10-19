package com.cipher.algorithm_visualization.E_Sort.quick.two_ways;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:43 2018/9/15
 */
public class QuickSortVisualizer2Way extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 200;

    public QuickSortVisualizer2Way(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new QuickSortData2Way(N, sceneHeight, QuickSortData2Way.Type.Default);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new QuickSortFrame2Way("Quick Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        QuickSortData2Way sortData = (QuickSortData2Way) getData();
        setData(-1, -1, -1, -1, -1, -1);
        quickSort2Ways(0, sortData.N() - 1);
        setData(-1, -1, -1, -1, -1, -1);
    }

    private void quickSort2Ways(int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            setData(l, r, l, -1, -1, -1);
            return;
        }
        setData(l, r, -1, -1, -1, -1);
        int p = partition(l, r);
        quickSort2Ways(l, p - 1);
        quickSort2Ways(p + 1, r);
    }

    private int partition(int l, int r) {
        QuickSortData2Way sortData = (QuickSortData2Way) getData();
        int p = (int) (Math.random() * (r - l + 1) + l);
        setData(l, r, -1, p, -1, -1);
        sortData.swap(l, p);
        int v = sortData.get(l);
        setData(l, r, -1, l, -1, -1);
        int i = l + 1;
        int j = r;
        setData(l, r, -1, l, i, j);
        while (true) {
            while (i <= r && sortData.get(i) < v) {
                i++;
                setData(l, r, -1, l, i, j);
            }
            while (j >= l + 1 && sortData.get(j) > v) {
                j--;
                setData(l, r, -1, l, i, j);
            }
            if (i > j) {
                break;
            }
            sortData.swap(i, j);
            i++;
            j--;
            setData(l, r, -1, l, i, j);
        }
        sortData.swap(l, j);
        setData(l, r, j, -1, -1, -1);
        return j;
    }

    private void setData(int l, int r, int fixedPivot, int curPivot, int curL, int curR) {
        QuickSortData2Way data = (QuickSortData2Way) getData();
        data.l = l;
        data.r = r;
        if (fixedPivot != -1) {
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new QuickSortVisualizer2Way(800, 300);
    }

}
