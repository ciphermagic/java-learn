package com.cipher.algorithm_visualization.D_Montecarlo.pi;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import java.awt.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:27 2018/9/13
 */
public class PiVisualizer extends AlgoVisualizer {

    private static final int N = 20000;
    private static final int DELAY = 40;

    public PiVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        return new MonteCarloPiData(circle);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new PiFrame("Get Pi with Monte Carlo", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        MonteCarloPiData piData = (MonteCarloPiData) data;
        for (int i = 0; i < N; i++) {
            if (i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
            }
            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());
            piData.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        new PiVisualizer(500, 500);
    }

}
