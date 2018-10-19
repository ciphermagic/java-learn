package com.cipher.algorithm_visualization.D_Montecarlo.montyhall;


/**
 * @Author: CipherCui
 * @Description: 三门问题
 * @Date: Created in 15:59 2018/9/14
 */
public class ThreeGatesExperiment {

    private int N;

    public ThreeGatesExperiment(int n) {
        N = n;
    }

    public void run(boolean changeDoor) {
        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (play(changeDoor)) {
                wins++;
            }
        }
        System.out.println(changeDoor ? "Change" : "Not Change");
        System.out.println("winning rate: " + (double) wins / N);
    }

    private boolean play(boolean changeDoor) {
        int winDoor = (int) (Math.random() * 3);
        int chooseDoor = (int) (Math.random() * 3);
        // 第一次选择是否赢
        boolean winAtFirst = winDoor == chooseDoor;
        // 换门：本来赢的变输，本来输的变赢
        // 不换门：本来赢就赢，输就输
        return changeDoor ? !winAtFirst : winAtFirst;
    }

    public static void main(String[] args) {
        int N = 1000000;
        ThreeGatesExperiment experiment = new ThreeGatesExperiment(N);
        experiment.run(true);
        experiment.run(false);
    }

}
