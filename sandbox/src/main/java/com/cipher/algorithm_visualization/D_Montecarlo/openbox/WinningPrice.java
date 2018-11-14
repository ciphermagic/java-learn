package com.cipher.algorithm_visualization.D_Montecarlo.openbox;

/**
 * @Author: CipherCui
 * @Description: 开宝箱问题
 * @Date: Created in 13:53 2018/9/15
 */
public class WinningPrice {

    private double chance;
    private int playtime;
    private int N;

    public WinningPrice(double chance, int playtime, int n) {
        this.chance = chance;
        this.playtime = playtime;
        N = n;
    }

    public void run() {
        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (play()) {
                wins++;
            }
        }
        System.out.println("winning rate: " + (double) wins / N);
    }

    private boolean play() {
        for (int i = 0; i < playtime; i++) {
            if (Math.random() < chance) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double chance = 0.2;
        int playtime = 5;
        int N = 1000000;
        WinningPrice price = new WinningPrice(chance, playtime, N);
        price.run();
    }

}
