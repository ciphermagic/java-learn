package com.cipher.algorithm_visualization.F_Maze;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:03 2018/9/21
 */
public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';
    private int N, M;
    private char[][] maze;
    private int entranceX, entranceY;
    private int exitX, exitY;
    public boolean[][] visited;
    public boolean[][] path;
    public boolean[][] result;

    public MazeData(String fileName) {
        Scanner scanner = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
            String nmLine = scanner.nextLine();
            String[] nm = nmLine.trim().split("\\s+");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);
            maze = new char[N][M];
            visited = new boolean[N][M];
            path = new boolean[N][M];
            result = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < M; j++) {
                    maze[i][j] = line.charAt(j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        this.entranceX = 1;
        this.entranceY = 0;
        this.exitX = N - 2;
        this.exitY = M - 1;
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

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public char getMaze(int i, int j) {
        return maze[i][j];
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public void print() {
        System.out.println(N + " " + M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/java/com/cipher/algoapi/E_Maze/maze_101_101.txt";
        MazeData mazeData = new MazeData(fileName);
        mazeData.print();
    }

}
