package com.cipher.algorithm_visualization.I_Move_Box;

import com.cipher.algorithm_visualization.A_Base.AlgoFrame;
import com.cipher.algorithm_visualization.A_Base.AlgoVisHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:39 2018/10/12
 */
public class GameFrame extends AlgoFrame {

    private HashMap<Character, Color> colorMap;
    private ArrayList<Color> colorList;

    public GameFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
        this.colorMap = new HashMap<>();
        this.colorList = new ArrayList<>();
        this.colorList.add(AlgoVisHelper.Red);
        this.colorList.add(AlgoVisHelper.Purple);
        this.colorList.add(AlgoVisHelper.Blue);
        this.colorList.add(AlgoVisHelper.Teal);
        this.colorList.add(AlgoVisHelper.LightGreen);
        this.colorList.add(AlgoVisHelper.Lime);
        this.colorList.add(AlgoVisHelper.Amber);
        this.colorList.add(AlgoVisHelper.DeepOrange);
        this.colorList.add(AlgoVisHelper.Brown);
        this.colorList.add(AlgoVisHelper.BlueGrey);
    }

    @Override
    public void paint(AlgoVisHelper algoVisHelper, Object obj) {
        GameData data = (GameData) obj;
        int w = getCanvasWidth() / data.M();
        int h = getCanvasHeight() / data.N();
        Board board = data.getShowBoard();
        for (int i = 0; i < board.N(); i++) {
            for (int j = 0; j < board.M(); j++) {
                char c = board.getData(i, j);
                if (c != Board.EMPTY) {
                    if (!colorMap.containsKey(c)) {
                        int sz = colorMap.size();
                        colorMap.put(c, colorList.get(sz));
                    }
                    algoVisHelper.setColor(colorMap.get(c));
                    algoVisHelper.fillRectangle(j * w + 2, i * h + 2, w - 4, h - 4);
                    algoVisHelper.setColor(AlgoVisHelper.White);
                    String text = String.format("(%d, %d)", i, j);
                    algoVisHelper.drawText(text, j * w + w / 2, i * h + h / 2);
                }
            }
        }
    }

}
