package W3_SmileyFace;

import javax.swing.*;
import java.awt.*;

public class SmileyFace extends JFrame {
    public SmileyFace(){
        setTitle("笑脸");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

        }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        //黄色笑脸底面
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200);
        //蓝色笑脸边框
        g.setColor(Color.BLUE);
        g.drawOval(50, 50, 200, 200);
        //蓝色的左眼眶
        g.drawOval(100, 100, 30, 30);
        //右眼眶
        g.drawOval(170, 100, 30, 30);
        //嘴
        g.drawArc(100, 120, 100, 80, 180, 180);
    }
    //主程序入口
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SmileyFace smiley = new SmileyFace();
            smiley.setVisible(true);
        });
    }
    }

