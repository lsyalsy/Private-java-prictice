package work1Count;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Count extends JFrame {
    int n = 0;
    //创建按钮
    JButton jbt = new JButton("+1");
    //JPanel
    JPanel jp  = new JPanel();
    JLabel jb = new JLabel("count: 0");
    public Count(){
        //界面初始化
        setTitle("计数器");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        //按钮时间监听器设置
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n++;
                jb.setText("次数:" + n);
            }
        });
        //组件添加
        this.add(jp);
        jp.add(jb);
        jp.add(jbt);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->  {
            Count count = new Count();
            //设置界面显示
            count.setVisible(true);
        });
    }
}