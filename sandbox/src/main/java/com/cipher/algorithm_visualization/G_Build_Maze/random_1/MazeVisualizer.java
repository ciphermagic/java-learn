package com.cipher.algorithm_visualization.G_Build_Maze.random_1;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;
import com.cipher.algorithm_visualization.G_Build_Maze.MazeData;
import com.cipher.algorithm_visualization.G_Build_Maze.MazeFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Author: CipherCui
 * @Description: 随机队列生成迷宫
 * @Date: Created in 11:41 2018/9/27
 */
public class MazeVisualizer extends AlgoVisualizer {

    private static final int N = 101;
    private static final int M = 101;
    private static final int BLOCK_SIDE = 6;
    private static final int DELAY = 1;
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new MazeData(N, M);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        MazeData data = (MazeData) getData();
        data.enableMist = true;
        MazeFrame frame = new MazeFrame("Build Maze", data.M() * BLOCK_SIDE, data.N() * BLOCK_SIDE);
        frame.addKeyListener(new AlgoKeyListener());
        return frame;
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        MazeData mazeData = (MazeData) data;
        setRoadData(-1, -1);

        RandomQueue<Position> queue = new RandomQueue<>();
        Position first = new Position(mazeData.getEntranceX(), mazeData.getEntranceY() + 1);
        queue.add(first);
        mazeData.visited[first.x][first.y] = true;
        mazeData.openMist(first.x, first.y);
        while (!queue.empty()) {
            Position curPos = queue.remove();
            for (int[] aD : d) {
                int newX = curPos.x + aD[0] * 2;
                int newY = curPos.y + aD[1] * 2;
                if (mazeData.inArea(newX, newY) && !mazeData.visited[newX][newY]) {
                    queue.add(new Position(newX, newY));
                    mazeData.visited[newX][newY] = true;
                    mazeData.openMist(newX, newY);
                    setRoadData(curPos.x + aD[0], curPos.y + aD[1]);
                }
            }
        }

        setRoadData(-1, -1);
    }

    private boolean go(int x, int y) {
        MazeData data = (MazeData) getData();
        data.visited[x][y] = true;
        setPathData(x, y, true);
        if (x == data.getExitX() && y == data.getExitY()) {
            return true;
        }
        for (int[] aD : d) {
            int newX = x + aD[0];
            int newY = y + aD[1];
            if (data.inArea(newX, newY) &&
                    data.maze[newX][newY] == MazeData.ROAD &&
                    !data.visited[newX][newY]) {
                if (go(newX, newY)) {
                    return true;
                }
            }
        }
        setPathData(x, y, false);
        return false;
    }

    private void setPathData(int x, int y, boolean isPath) {
        MazeData data = (MazeData) getData();
        if (data.inArea(x, y)) {
            data.path[x][y] = isPath;
        }
        getFrame().render(getData());
        AlgoVisHelper.pause(DELAY);
    }

    private void setRoadData(int x, int y) {
        MazeFrame frame = (MazeFrame) getFrame();
        MazeData data = (MazeData) getData();
        if (data.inArea(x, y)) {
            data.maze[x][y] = MazeData.ROAD;
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            MazeData data = (MazeData) getData();
            if (event.getKeyChar() == ' ') {
                for (int i = 0; i < data.N(); i++) {
                    for (int j = 0; j < data.M(); j++) {
                        data.visited[i][j] = false;
                    }
                }
                new Thread(() -> {
                    go(data.getEntranceX(), data.getEntranceY());
                }).start();
            }
        }
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
