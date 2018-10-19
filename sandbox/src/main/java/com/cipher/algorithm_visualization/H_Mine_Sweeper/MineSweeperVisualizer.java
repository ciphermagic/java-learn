package com.cipher.algorithm_visualization.H_Mine_Sweeper;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;
import com.cipher.algorithm_visualization.A_Base.AlgoVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:02 2018/10/10
 */
public class MineSweeperVisualizer extends AlgoVisualizer {

    private static final int N = 20;
    private static final int M = 20;
    private static final int MINE_NUMBER = 50;
    private static final int DELAY = 5;

    @Override
    public Object initData(int sceneWidth, int sceneHeight) {
        return new MineSweeperData(N, M, MINE_NUMBER);
    }

    @Override
    public AlgoFrame initFrame(int sceneWidth, int sceneHeight) {
        MineSweeperFrame frame = new MineSweeperFrame("Mine Sweeper", N * MineSweeperData.BLOCK_SIDE, M * MineSweeperData.BLOCK_SIDE);
        frame.addMouseListener(new AlgoMouseListener());
        frame.addKeyListener(new AlgoKeyListener());
        return frame;
    }

    @Override
    public void run(Object data, AlgoFrame frame) {
        setData(true, -1, -1);
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            MineSweeperData data = (MineSweeperData) getData();
            if (e.getKeyChar() == ' ') {
                data.resetGame();
                setData(true, -1, -1);
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            MineSweeperData data = (MineSweeperData) getData();
            AlgoFrame frame = getFrame();
            e.translatePoint(-(frame.getBounds().width - frame.getCanvasWidth()),
                    -(frame.getBounds().height - frame.getCanvasHeight()));
            Point point = e.getPoint();
            int w = frame.getCanvasWidth() / data.M();
            int h = frame.getCanvasHeight() / data.N();
            int x = point.y / h;
            int y = point.x / w;
            setData(SwingUtilities.isLeftMouseButton(e), x, y);
        }
    }

    private void setData(boolean isLeftClicked, int x, int y) {
        MineSweeperData data = (MineSweeperData) getData();
        AlgoFrame frame = getFrame();
        if (data.inArea(x, y)) {
            if (isLeftClicked) {
                if (data.isMine(x, y)) {
                    data.gameOver();
                } else {
                    data.open(x, y);
                }
            } else {
                data.flags[x][y] = !data.flags[x][y];
            }
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new MineSweeperVisualizer();
    }

}
