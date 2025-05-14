package SmileyFace;

import javax.swing.*;
import java.awt.*;

public class SmileyFace extends JFrame {

    public SmileyFace() {
        setTitle("Smiley Face");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制黄色圆形脸
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200);

        // 绘制红色边框
        g.setColor(Color.RED);
        g.drawOval(50, 50, 200, 200);

        g.setColor(Color.BLUE);
        // 绘制左眼
        g.drawOval(100, 100, 30, 30);

        // 绘制右眼
        g.drawOval(170, 100, 30, 30);

        // 绘制微笑的嘴
        g.drawArc(100, 120, 100, 80, 180, 180);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SmileyFace smiley = new SmileyFace();
            smiley.setVisible(true);
        });
    }
}
