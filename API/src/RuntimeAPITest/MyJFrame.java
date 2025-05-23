package RuntimeAPITest;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyJFrame extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new MyJFrame();
    }
    JButton goodButton = new JButton("帅的一批");
    JButton normalButton = new JButton("帅的一般般");
    JButton badButton = new JButton("丑得惨绝人寰");
    JButton cancelButton = new JButton("饶了我吧");

    boolean flag = false;

    public MyJFrame(){
        //界面初始化
        initJFrame();
        initView();

        setVisible(true);
    }

    private void initJFrame() {
        setSize(500, 600);
        setTitle("诚信测试");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);
    }


    private void initView() {
        this.getContentPane().removeAll();

        if(flag){
            //展示按钮
            cancelButton.setBounds(80, 20, 350, 200);
            cancelButton.addActionListener(this);
            this.getContentPane().add(cancelButton);
        }

        JLabel text = new JLabel("你觉得你很帅吗？");
        text.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        text.setBounds(120, 150, 300, 50);

        goodButton.setBounds(200, 250, 100, 30);
        normalButton.setBounds(200, 325, 100, 30);
        badButton.setBounds(160, 400, 180, 30);

        goodButton.addActionListener(this);
        normalButton.addActionListener(this);
        badButton.addActionListener(this);

        getContentPane().add(text);
        getContentPane().add(goodButton);
        getContentPane().add(normalButton);
        getContentPane().add(badButton);

        getContentPane().repaint();
    }

    public void showJDialog1(String content){
        //设置一个弹框
        JDialog jd = new JDialog();
        jd.setSize(300, 150);
        jd.setAlwaysOnTop(true);
        jd.setLocationRelativeTo(null);

        //弹窗不关闭无法操作下面的窗口
        jd.setModal(true);

        //创建JLabel对象管理文字并添加到弹框中
        JLabel j1 = new JLabel(content);
        j1.setBounds(0, 0, 300, 150);
        jd.getContentPane().add(j1);

        //显示弹窗
        jd.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //判断按钮，做出不同的反应
        Object source = e.getSource();
        if (source == goodButton) {
            showJDialog1("勋噶,你很不诚实哦，给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 20");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            flag = true;
            initView();
        } else if (source == normalButton) {
            showJDialog1("xxx,你不太诚实哦，给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 40");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            flag = true;
            initView();
        } else if (source == badButton) {
            showJDialog1("略微诚实，也给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 60");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            flag = true;
            initView();
        } else if (source == cancelButton) {
            showJDialog1("xxx，你还有点自知之明，暂且饶过你");
            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
