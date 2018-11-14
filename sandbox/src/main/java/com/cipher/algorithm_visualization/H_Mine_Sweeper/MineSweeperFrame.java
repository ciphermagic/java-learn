package com.cipher.algorithm_visualization.H_Mine_Sweeper;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:39 2018/10/10
 */
public class MineSweeperFrame extends AlgoFrame {

    public MineSweeperFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object obj) {
        MineSweeperData data = (MineSweeperData) obj;
        int w = getCanvasWidth() / data.M();
        int h = getCanvasHeight() / data.N();
        for (int i = 0; i < data.N(); i++) {
            for (int j = 0; j < data.M(); j++) {
                if (data.open[i][j]) {
                    if (data.isMine(i, j)) {
                        algoVisHelper.putImage(j * w, i * h, MineSweeperData.MINE_IMAGE_URL);
                    } else {
                        algoVisHelper.putImage(j * w, i * h, MineSweeperData.numberImageURL(data.getNumber(i, j)));
                    }
                } else {
                    if (data.flags[i][j]) {
                        algoVisHelper.putImage(j * w, i * h, MineSweeperData.FLAG_IMAGE_URL);
                    } else {
                        algoVisHelper.putImage(j * w, i * h, MineSweeperData.BLOCK_IMAGE_URL);
                    }
                }
            }
        }
    }

}
