package com.cipher.algorithm_visualization.G_Build_Maze;

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
    public boolean[][] visited;
    public boolean[][] inMist;
    public boolean[][] path;
    public boolean[][] result;
    public boolean enableMist;

    public MazeData(int N, int M) {
        this.N = N;
        this.M = M;
        this.maze = new char[N][M];
        this.visited = new boolean[N][M];
        this.inMist = new boolean[N][M];
        this.path = new boolean[N][M];
        this.result = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    maze[i][j] = ROAD;
                } else {
                    maze[i][j] = WALL;
                }
                inMist[i][j] = true;
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

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public void openMist(int newX, int newY) {
        for (int i = newX - 1; i <= newX + 1; i++) {
            for (int j = newY - 1; j <= newY + 1; j++) {
                this.inMist[i][j] = false;
            }
        }
    }
}
