package com.cipher.algoapi.H_Mine_Sweeper;

import com.cipher.algoapi.A_Base.AlgoFrame;
import com.cipher.algoapi.A_Base.AlgoVisHelper;
import com.cipher.algoapi.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:02 2018/10/10
 */
public class MineSweeperVisualizer extends AlgoVisualizer {

    private static final int N = 20;
    private static final int M = 20;
    private static final int MINE_NUMBER = 50;
    private static final int DELAY = 5;

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new MineSweeperData(N, M, MINE_NUMBER);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new MineSweeperFrame("Mine Sweeper", N * MineSweeperData.BLOCK_SIDE, M * MineSweeperData.BLOCK_SIDE);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new MineSweeperVisualizer();
    }

}
