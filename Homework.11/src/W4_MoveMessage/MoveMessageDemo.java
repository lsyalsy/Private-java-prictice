package W4_MoveMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveMessageDemo extends JFrame {
    private String message = "Welcome to java!";
    private int x = 20;
    private int y = 40;
    private int xDirection = 1;
    private int yDirection = 1;
    private final int Step = 5;

    public MoveMessageDemo(){
        setTitle("MoveMessageDemo");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 使用常量替代魔法数字
        setSize(400,500);
        setAlwaysOnTop(true);

        Timer timer = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                x += Step * xDirection;
                y += Step * yDirection;
                if(x > getWidth() - 70){
                    xDirection = -1;
                }else if(x < 20){
                    xDirection = 1;
                }

                if(y >= getHeight() - 100){
                    yDirection = -1;
                }else if(y <= 20){
                    yDirection = 1;
                }

                repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(message, x, y);
    }

    //主程序启动
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MoveMessageDemo m = new MoveMessageDemo();
            m.setVisible(true);
        });
    }
}
