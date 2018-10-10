package com.cipher.algoapi.H_Mine_Sweeper;

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

    public static String numberImageURL(int num) {
        return PREFIX + num + ".png";
    }

    private int N, M;
    private boolean[][] mines;

    public MineSweeperData(int N, int M, int mineNumber) {
        this.N = N;
        this.M = M;
        this.mines = new boolean[N][M];
        generateMines(mineNumber);
    }

    private void generateMines(int mineNumber) {
        for (int i = 0; i < mineNumber; i++) {
            int x = i / M;
            int y = i % M;
            this.mines[x][y] = true;
        }
        for (int i = 0; i < mineNumber; i++) {
            int x1 = i / M;
            int y1 = i % M;
            int x2 = (int) (Math.random() * N);
            int y2 = (int) (Math.random() * M);
            swap(x1, y1, x2, y2);
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

    public boolean isMine(int x, int y) {
        if (inArea(x, y)) {
            return mines[x][y];
        }
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
