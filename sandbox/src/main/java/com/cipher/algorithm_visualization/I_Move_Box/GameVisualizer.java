package com.cipher.algorithm_visualization.I_Move_Box;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:40 2018/10/12
 */
public class GameVisualizer extends AlgoVisualizer {

    private static final int BLOCK_SIDE = 80;
    private static final int DELAY = 5;
    private static final String PREFIX = "src/main/java/com/cipher/algoapi/I_Move_Box/level/";
    private static final String FILENAME = PREFIX + "newyork_06.txt";

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new GameData(FILENAME);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        GameData data = (GameData) getData();
        return new GameFrame("Move the Box", data.M() * BLOCK_SIDE, data.N() * BLOCK_SIDE);
    }

    @Override
    public void run(Object obj, AlgoFrame frame) {
        GameData data = (GameData) getData();
        setData();
        if (data.solve()) {
            System.out.println("The game has a solution!");
        } else {
            System.out.println("The game dose NOT have a solution.");
        }
        setData();
    }

    private void setData() {
        GameData data = (GameData) getData();
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new GameVisualizer();
    }

}
