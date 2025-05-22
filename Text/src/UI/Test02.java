package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test02 extends JFrame implements ActionListener{
    //创建按钮对象
    JButton jbt1 = new JButton("按钮");
    JButton jbt2 = new JButton("按钮");
    public Test02() {
        //界面初始化
        JFrame frame = new JFrame("演示");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(3);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        //设置宽和高
        jbt1.setBounds(0,0,100, 50);
        jbt2.setBounds(100,0,100, 50);
        //添加事件监听器
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);
        //添加按钮
        frame.getContentPane().add(jbt1);
        frame.getContentPane().add(jbt2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //判断当前按钮
        Object source = e.getSource();
        if(source == jbt1){
            System.out.println("按钮1被点击了");
        } else if (source == jbt2) {
            System.out.println("按钮2被点击了");
        }

    }
}
