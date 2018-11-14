package com.cipher.algorithm_visualization.A_Base;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @Author: CipherCui
 * @Description: 窗口绘画辅助类
 * @Date: Created in 14:06 2018/9/10
 */
public class AlgoVisHelper {

    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPurple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51B5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    private Graphics2D g2d;

    private AlgoVisHelper(Graphics2D g2d) {
        // 抗锯齿
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);
        this.g2d = g2d;
    }

    public static AlgoVisHelper getInstance(Graphics g) {
        return new AlgoVisHelper((Graphics2D) g);
    }

    public void setStrokeWidth(int strokeWidth) {
        this.g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public void setColor(Color color) {
        this.g2d.setColor(color);
    }

    public void strokeCircle(int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        this.g2d.draw(circle);
    }

    public void fillCircle(int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        this.g2d.fill(circle);
    }

    public void strokeRectangle(int x, int y, int w, int h) {
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g2d.draw(rectangle);
    }

    public void fillRectangle(int x, int y, int w, int h) {
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g2d.fill(rectangle);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.closePath();
        g2d.fill(path);
    }

    public void putImage(int x, int y, String imageURL) {
        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();
        g2d.drawImage(image, x, y, null);
    }

    public void drawText(String text, int centerx, int centery) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null in drawText function!");
        }
        FontMetrics metrics = g2d.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g2d.drawString(text, centerx - w / 2, centery + h);
    }

    public void drawLine(double x1, double y1, double x2, double y2){
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(line);
    }

    public static void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
