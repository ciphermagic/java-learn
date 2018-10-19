package com.cipher.algorithm_visualization.G_Build_Maze;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:35 2018/9/27
 */
public class MazeFrame extends AlgoFrame {

    public MazeFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object data) {
        MazeData mazeData = (MazeData) data;
        int w = getCanvasWidth() / mazeData.M();
        int h = getCanvasHeight() / mazeData.N();
        for (int i = 0; i < mazeData.N(); i++) {
            for (int j = 0; j < mazeData.M(); j++) {
                if (mazeData.enableMist && mazeData.inMist[i][j]) {
                    algoVisHelper.setColor(AlgoVisHelper.Black);
                } else {
                    if (mazeData.maze[i][j] == MazeData.WALL) {
                        algoVisHelper.setColor(AlgoVisHelper.LightBlue);
                    } else {
                        algoVisHelper.setColor(AlgoVisHelper.White);
                    }
                    if (mazeData.path[i][j]) {
                        algoVisHelper.setColor(AlgoVisHelper.Yellow);
                    }
                }
                algoVisHelper.fillRectangle(j * w, i * h, w, h);
            }
        }
    }

}
