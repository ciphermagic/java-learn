package com.cipher.algorithm_visualization.J_Fractal_Drawing.sierpinski_carpet;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:55 2018/10/15
 */
public class CarpetVisualizer extends AlgoVisualizer {

    private static final int DELAY = 5;
    private static final int MAX_DEPTH = 6;

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new CarpetData(MAX_DEPTH);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        int w = (int) Math.pow(3, MAX_DEPTH);
        int h = (int) Math.pow(3, MAX_DEPTH);
        AlgoFrame frame = new CarpetFrame("Sierpinski Carpet Fractal", w, h);
        frame.addKeyListener(new AlgoKeyListener());
        return frame;
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        setData(0);
    }

    private void setData(int depth) {
        CarpetData data = (CarpetData) getData();
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
        new CarpetVisualizer();
    }

}
