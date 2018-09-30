package com.cipher.algoapi.F_Build_Maze;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:03 2018/9/21
 */
public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';
    private int N, M;
    public char[][] maze;
    private int entranceX, entranceY;
    private int exitX, exitY;

    public MazeData(int N, int M) {
        this.N = N;
        this.M = M;
        this.maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    maze[i][j] = ROAD;
                } else {
                    maze[i][j] = WALL;
                }
            }
        }
        this.entranceX = 1;
        this.entranceY = 0;
        this.exitX = N - 2;
        this.exitY = M - 1;
        this.maze[entranceX][entranceY] = ROAD;
        this.maze[exitX][exitY] = ROAD;
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }
}
