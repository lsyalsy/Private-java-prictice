package LoveheartDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class LoveheartDemo extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 设置抗锯齿和颜色
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);

        // 心形参数方程
        int scale = 15; // 缩放系数
        int offsetX = getWidth()/2;  // 水平居中
        int offsetY = getHeight()/3; // 垂直位置

        // 创建爱心路径
        GeneralPath path = new GeneralPath();
        for (double t = 0; t <= 2 * Math.PI; t += 0.01) {
            double x = 16 * Math.pow(Math.sin(t), 3);
            double y = 13 * Math.cos(t) - 5 * Math.cos(2*t)
                      - 2 * Math.cos(3*t) - Math.cos(4*t);

            if (t == 0) {
                path.moveTo(offsetX + x * scale, offsetY - y * scale);
            } else {
                path.lineTo(offsetX + x * scale, offsetY - y * scale);
            }
        }
        path.closePath();

        // 绘制填充和边框
        g2d.fill(path);
        g2d.setColor(new Color(150, 0, 0)); // 深红色边框
        g2d.draw(path);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Love Yan");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new LoveheartDemo());
        frame.setVisible(true);
    }
}
