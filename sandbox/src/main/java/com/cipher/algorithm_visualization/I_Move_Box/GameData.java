package com.cipher.algorithm_visualization.I_Move_Box;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:07 2018/10/12
 */
public class GameData {

    private int maxTurn;
    private Board starterBoard;
    private Board showBoard;
    private int N, M;

    public GameData(String filename) {
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(new BufferedInputStream(fis), "UTF-8")) {
            String turnLine = scanner.nextLine();
            this.maxTurn = Integer.parseInt(turnLine.trim());
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            this.starterBoard = new Board(lines.toArray(new String[0]));
            this.showBoard = new Board(this.starterBoard);
            this.N = this.starterBoard.N();
            this.M = this.starterBoard.M();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public Board getShowBoard() {
        return showBoard;
    }

    public boolean solve() {
        if (maxTurn < 0) {
            return false;
        }
        return solve(starterBoard, maxTurn);
    }

    private static int[][] d = {{1, 0}, {0, 1}, {0, -1}};

    private boolean solve(Board board, int turn) {
        if (turn == 0) {
            return board.isWin();
        }
        if (board.isWin()) {
            return true;
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (board.getData(x, y) != Board.EMPTY) {
                    for (int[] aD : d) {
                        int newX = x + aD[0];
                        int newY = y + aD[1];
                        if (inArea(newX, newY)) {
                            String swapString = String.format("swap (%d, %d) and (%d, %d)", x, y, newX, newY);
                            Board nextBoard = new Board(board, board, swapString);
                            nextBoard.swap(x, y, newX, newY);
                            nextBoard.run();
                            if (solve(nextBoard, turn - 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
