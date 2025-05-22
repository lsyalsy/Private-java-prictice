package MyMouseListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class test01 extends JFrame implements MouseListener {
    public test01() {
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

        //设置按钮监听
        jbt.addMouseListener(this);
        frame.getContentPane().add(jbt);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单机");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
