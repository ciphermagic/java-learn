package com.cipher.algorithm_visualization.E_Sort.quick.three_ways;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:43 2018/9/15
 */
public class QuickSortVisualizer3Way extends AlgoVisualizer {

    private static final int N = 100;
    private static final int DELAY = 20;

    public QuickSortVisualizer3Way(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new QuickSortData3Way(N, sceneHeight, QuickSortData3Way.Type.Default);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new QuickSortFrame3Way("Quick Sort", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        QuickSortData3Way sortData = (QuickSortData3Way) getData();
        setData(-1, -1, -1, -1, -1, -1);
        quickSort3Ways(0, sortData.N() - 1);
        setData(-1, -1, -1, -1, -1, -1);
    }

    private void quickSort3Ways(int l, int r) {
        QuickSortData3Way data = (QuickSortData3Way) getData();
        if (l > r) {
            return;
        }
        if (l == r) {
            setData(l, r, l, -1, -1, -1);
            return;
        }
        setData(l, r, -1, -1, -1, -1);
        int p = (int) (Math.random() * (r - l + 1)) + l;
        setData(l, r, -1, p, -1, -1);
        data.swap(l, p);
        int v = data.get(l);
        setData(l, r, -1, l, -1, -1);
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        setData(l, r, -1, l, lt, gt);
        while (i < gt) {
            if (data.get(i) < v) {
                data.swap(i, lt + 1);
                i++;
                lt++;
            } else if (data.get(i) > v) {
                data.swap(i, gt - 1);
                gt--;
            } else {
                i++;
            }
            setData(l, r, -1, l, i, gt);
        }
        data.swap(l, lt);
        setData(l, r, lt, -1, -1, -1);
        quickSort3Ways(l, lt - 1);
        quickSort3Ways(gt, r);
    }


    private void setData(int l, int r, int fixedPivot, int curPivot, int curL, int curR) {
        QuickSortData3Way data = (QuickSortData3Way) getData();
        data.l = l;
        data.r = r;
        if (fixedPivot != -1) {
            data.fixedPivots[fixedPivot] = true;
            int i = fixedPivot;
            while (i < data.N() && data.get(i) == data.get(fixedPivot)) {
                data.fixedPivots[i] = true;
                i++;
            }
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new QuickSortVisualizer3Way(800, 300);
    }

}
