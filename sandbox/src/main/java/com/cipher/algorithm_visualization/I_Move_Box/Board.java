package com.cipher.algorithm_visualization.I_Move_Box;

/**
 * @Author: CipherCui
 * @Description: 游戏盘面
 * @Date: Created in 11:18 2018/10/12
 */
public class Board {

    private int N, M;
    private char[][] data;
    public static final char EMPTY = '.';
    private Board preBoard;
    private String swapString = "";

    public Board(String[] lines) {
        this.N = lines.length;
        this.M = lines[0].length();
        this.data = new char[N][M];
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.M; j++) {
                data[i][j] = lines[i].charAt(j);
            }
        }
    }

    public Board(Board board, Board preBoard, String swapString) {
        this.N = board.N;
        this.M = board.M;
        this.data = new char[N][M];
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.M; j++) {
                data[i][j] = board.data[i][j];
            }
        }
        this.preBoard = preBoard;
        this.swapString = swapString;
    }

    public Board(Board board) {
        this(board, null, "");
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

    public char getData(int x, int y) {
        return this.data[x][y];
    }

    public void print() {
        for (int i = 0; i < this.N; i++) {
            System.out.println(String.valueOf(data[i]));
        }
    }

    public boolean isWin() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] != EMPTY) {
                    return false;
                }
            }
        }
        printSwapInfo();
        return true;
    }

    private void printSwapInfo() {
        if (this.preBoard != null) {
            preBoard.printSwapInfo();
        }
        System.out.println(swapString);
    }

    public void swap(int x1, int y1, int x2, int y2) {
        char temp = data[x1][y1];
        data[x1][y1] = data[x2][y2];
        data[x2][y2] = temp;
    }

    public void run() {
        do {
            drop();
        } while (match());
    }

    private void drop() {
        for (int j = 0; j < M; j++) {
            int cur = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (data[i][j] != EMPTY) {
                    swap(i, j, cur, j);
                    cur--;
                }
            }
        }
    }

    private static int[][] d = {{0, 1}, {1, 0}};

    private boolean match() {
        boolean isMatched = false;
        boolean[][] tag = new boolean[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (data[x][y] != EMPTY) {
                    for (int[] aD : d) {
                        int newX1 = x + aD[0];
                        int newY1 = y + aD[1];
                        int newX2 = newX1 + aD[0];
                        int newY2 = newY1 + aD[1];
                        if (inArea(newX1, newY1) && inArea(newX2, newY2) &&
                                data[newX1][newY1] == data[x][y] &&
                                data[newX2][newY2] == data[x][y]) {
                            tag[x][y] = true;
                            tag[newX1][newY1] = true;
                            tag[newX2][newY2] = true;
                            isMatched = true;
                        }
                    }
                }
            }
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (tag[x][y]) {
                    data[x][y] = EMPTY;
                }
            }
        }
        return isMatched;
    }

}
