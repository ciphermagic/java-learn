package com.cipher.algorithm_visualization.H_Mine_Sweeper;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:38 2018/10/10
 */
public class MineSweeperData {

    private static final String PREFIX = "src/main/java/com/cipher/algoapi/H_Mine_Sweeper/images/";
    public static final String BLOCK_IMAGE_URL = PREFIX + "block.png";
    public static final String FLAG_IMAGE_URL = PREFIX + "flag.png";
    public static final String MINE_IMAGE_URL = PREFIX + "mine.png";
    public static final int BLOCK_SIDE = 32;
    private static final int D[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static String numberImageURL(int num) {
        return PREFIX + num + ".png";
    }

    private int N, M, mineNumber;
    private boolean[][] mines;
    private int[][] numbers;
    public boolean[][] open;
    public boolean[][] flags;

    public MineSweeperData(int N, int M, int mineNumber) {
        this.N = N;
        this.M = M;
        this.mineNumber = mineNumber;
        this.mines = new boolean[N][M];
        this.open = new boolean[N][M];
        this.flags = new boolean[N][M];
        this.numbers = new int[N][M];
        generateMines(mineNumber);
        calculateNumbers();
    }

    private void calculateNumbers() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mines[i][j]) {
                    numbers[i][j] = -1;
                    continue;
                }
                // 判断周围 8 个方向
                for (int[] aD : D) {
                    int newX = i + aD[0];
                    int newY = j + aD[1];
                    if (inArea(newX, newY) && isMine(newX, newY)) {
                        numbers[i][j]++;
                    }
                }
            }
        }
    }

    private void generateMines(int mineNumber) {
        for (int i = 0; i < mineNumber; i++) {
            int x = i / M;
            int y = i % M;
            this.mines[x][y] = true;
        }
        for (int i = N * M - 1; i >= 0; i--) {
            int iX = i / M;
            int iY = i % M;
            int randNumber = (int) (Math.random() * (i + 1));
            int randX = randNumber / M;
            int randY = randNumber % M;
            swap(iX, iY, randX, randY);
        }
    }

    private void swap(int x1, int y1, int x2, int y2) {
        boolean t = mines[x1][y1];
        mines[x1][y1] = mines[x2][y2];
        mines[x2][y2] = t;
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public void resetGame() {
        this.mines = new boolean[N][M];
        this.open = new boolean[N][M];
        this.flags = new boolean[N][M];
        this.numbers = new int[N][M];
        generateMines(this.mineNumber);
        calculateNumbers();
    }

    public void gameOver() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.open[i][j] = true;
            }
        }
    }

    public int getNumber(int x, int y) {
        return numbers[x][y];
    }

    public boolean isMine(int x, int y) {
        if (inArea(x, y)) {
            return mines[x][y];
        }
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public void open(int x, int y) {
        open[x][y] = true;
        if (numbers[x][y] > 0) {
            return;
        }
        for (int[] aD : D) {
            int newX = x + aD[0];
            int newY = y + aD[1];
            if (inArea(newX, newY) && !isMine(newX, newY) && !open[newX][newY]) {
                open(newX, newY);
            }
        }
    }

}
