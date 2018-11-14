package com.cipher.algorithm_visualization.J_Fractal_Drawing.tree_fractal;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:54 2018/10/15
 */
public class TreeVisualizer extends AlgoVisualizer {

    private static final int DELAY = 5;
    private static final int MAX_DEPTH = 6;
    private static final double SPLIT_ANGLE = 60.0;

    public TreeVisualizer(int sceneWidth, int sceneHeight) {
        super(sceneWidth, sceneHeight);
    }

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new TreeData(MAX_DEPTH, SPLIT_ANGLE);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        AlgoFrame frame = new TreeFrame("Tree Fractal", sceneWidth, sceneHeight);
        frame.addKeyListener(new AlgoKeyListener());
        return frame;
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        setData(0);
    }

    private void setData(int depth) {
        TreeData data = (TreeData) getData();
        data.depth = depth;
        getFrame().render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            char keyChar = event.getKeyChar();
            if (keyChar >= '0' && keyChar <= '9') {
                int depth = keyChar - '0';
                setData(depth);
            }
        }
    }

    public static void main(String[] args) {
        new TreeVisualizer(800, 800);
    }
}
