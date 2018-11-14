package com.cipher.algorithm_visualization.J_Fractal_Drawing.recursive_circle;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:47 2018/10/15
 */
public class CircleVisualizer extends AlgoVisualizer {

    public CircleVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        int R = Math.min(sceneWidth, sceneHeight) / 2 - 2;
        return new CircleData(sceneWidth / 2, sceneHeight / 2, R, R / 2, 2);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        return new CircleFrame("Fractal Visualizer", sceneWidth, sceneHeight);
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        frame.render(data);
    }

    public static void main(String[] args) {
        new CircleVisualizer(800, 800);
    }

}
