package work2Captial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Captial extends JFrame {
    public Captial(){
        //界面初始化
        setTitle("转化大写");
        setSize(500, 100);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        //创建JPanel
        JPanel jPanel = new JPanel();

        //创建JLabel
        JLabel jLabel = new JLabel("文本内容：");

        //创建文本框
        JTextField jTextField = new JTextField(20);

        //按钮
        JButton jButton = new JButton("转化");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String upText = Up(jTextField.getText());
                jTextField.setText(upText);
            }
        });

        //添加组件
        this.add(jPanel);
        jPanel.add(jButton);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
    }

    private String Up(String inputText){
        String regex = "[a-z]";
        StringBuilder result  = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            String str = String.valueOf(c);
            if(str.matches(regex)){
                c = (char)(c - 32);
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Captial captial =new Captial();
            captial.setVisible(true);
        });

    }
}