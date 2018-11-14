package com.cipher.algorithm_visualization.G_Build_Maze.bfs;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;
import com.cipher.algorithm_visualization.G_Build_Maze.MazeData;
import com.cipher.algorithm_visualization.G_Build_Maze.MazeFrame;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;

/**
 * @Author: CipherCui
 * @Description: 广度优先生成迷宫
 * @Date: Created in 11:41 2018/9/27
 */
public class MazeVisualizer extends AlgoVisualizer {

    private static final int N = 101;
    private static final int M = 101;
    private static final int BLOCK_SIDE = 6;
    private static final int DELAY = 5;
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new MazeData(N, M);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        MazeData data = (MazeData) getData();
        return new MazeFrame("Build Maze", data.M() * BLOCK_SIDE, data.N() * BLOCK_SIDE);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        MazeData mazeData = (MazeData) data;
        setData(-1, -1);

        LinkedList<Position> queue = new LinkedList<>();
        Position first = new Position(mazeData.getEntranceX(), mazeData.getEntranceY() + 1);
        queue.addLast(first);
        mazeData.visited[first.x][first.y] = true;
        while (!CollectionUtils.isEmpty(queue)) {
            Position curPos = queue.removeFirst();
            for (int[] aD : d) {
                int newX = curPos.x + aD[0] * 2;
                int newY = curPos.y + aD[1] * 2;
                if (mazeData.inArea(newX, newY) && !mazeData.visited[newX][newY]) {
                    queue.addLast(new Position(newX, newY));
                    mazeData.visited[newX][newY] = true;
                    setData(curPos.x + aD[0], curPos.y + aD[1]);
                }
            }
        }

        setData(-1, -1);
    }

    private void setData(int x, int y) {
        MazeFrame frame = (MazeFrame) getFrame();
        MazeData data = (MazeData) getData();
        if (data.inArea(x, y)) {
            data.maze[x][y] = MazeData.ROAD;
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class Position {
        private int x, y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new MazeVisualizer();
    }

}
