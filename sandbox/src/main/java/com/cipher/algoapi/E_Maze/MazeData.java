package com.cipher.algoapi.E_Maze;

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

    private int N, M;
    private char[][] maze;

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
