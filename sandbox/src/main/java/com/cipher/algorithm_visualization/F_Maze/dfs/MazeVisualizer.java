package com.cipher.algorithm_visualization.F_Maze.dfs;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;
import com.cipher.algorithm_visualization.F_Maze.MazeData;
import com.cipher.algorithm_visualization.F_Maze.MazeFrame;

/**
 * @Author: CipherCui
 * @Description: 深度优先递归走迷宫
 * @Date: Created in 11:41 2018/9/27
 */
public class MazeVisualizer extends AlgoVisualizer {

    private static final String FILE_NAME = "src/main/java/com/cipher/algoapi/E_Maze/maze_101_101.txt";
    private static final int BLOCK_SIDE = 6;
    private static final int DELAY = 1;
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new MazeData(FILE_NAME);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        MazeData data = (MazeData) getData();
        return new MazeFrame("Maze Solver", data.M() * BLOCK_SIDE, data.N() * BLOCK_SIDE);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        MazeData mazeData = (MazeData) data;
        setData(-1, -1, false);
        if (!go(mazeData.getEntranceX(), mazeData.getEntranceY())) {
            System.out.println("The maze has NO solution!");
        }
        setData(-1, -1, false);
    }

    private boolean go(int x, int y) {
        MazeData data = (MazeData) getData();
        data.visited[x][y] = true;
        setData(x, y, true);
        if (x == data.getExitX() && y == data.getExitY()) {
            return true;
        }
        for (int[] aD : d) {
            int newX = x + aD[0];
            int newY = y + aD[1];
            if (data.inArea(newX, newY) &&
                    data.getMaze(newX, newY) == MazeData.ROAD &&
                    !data.visited[newX][newY]) {
                if (go(newX, newY)) {
                    return true;
                }
            }
        }
        setData(x, y, false);
        return false;
    }

    private void setData(int x, int y, boolean isPath) {
        MazeData data = (MazeData) getData();
        if (data.inArea(x, y)) {
            data.path[x][y] = isPath;
        }
        getFrame().render(getData());
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new MazeVisualizer();
    }

}
