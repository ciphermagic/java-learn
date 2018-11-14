package com.cipher.algorithm_visualization.C_Money;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:34 2018/9/11
 */
public class MoneyVisualizer extends AlgoVisualizer {

    private static final int DELAY = 40;
    private static final boolean IS_ALLOW_NEGATIVE = false;

    public MoneyVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        int N = 100;
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = 100;
        }
        return money;
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new MoneyFrame("Money Problem", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        int[] money = (int[]) data;
        while (true) {
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);
            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < money.length; i++) {
                    int j = (int) (Math.random() * money.length);
                    if (!IS_ALLOW_NEGATIVE && money[i] > 0) {
                        money[j]++;
                        money[i]--;
                    } else if (IS_ALLOW_NEGATIVE) {
                        money[j]++;
                        money[i]--;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        new MoneyVisualizer(1000, 800);
    }


}
