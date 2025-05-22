package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test01 extends JFrame {
    public Test01() {
        //界面初始化
        JFrame frame = new JFrame("演示");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(3);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        //创建按钮对象
        JButton jbt = new JButton("按钮");
        //设置宽和高
        jbt.setBounds(0,0,100, 50);
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });
        frame.getContentPane().add(jbt);
        frame.setVisible(true);
    }
}
