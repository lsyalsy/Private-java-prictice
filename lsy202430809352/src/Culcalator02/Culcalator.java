package Culcalator02;

import javax.swing.*;
import java.awt.*;

public class Culcalator extends JFrame {

    // 显示输入输出的文本框
    private JTextField display;
// 存储当前输入的数字
    private String currentInput = "";
// 存储第一个操作数
    private double firstOprtand = 0;
// 存储当前运算符
    private String currentOprator = "";
// 标记是否开始新的输入
    private boolean newInput = true;
public Culcalator(){
    // 设置窗口标题
    setTitle("简单计算器");
// 设置窗口大小
    setSize(300, 400);
// 设置窗口关闭行为
    setDefaultCloseOperation(3);
// 设置窗口居中显示
    setLocationRelativeTo(null);
// 创建主面板
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
// 创建显示文本框
    display = new JTextField();
// 设置为不可编辑
    display.setEditable(false);
// 文本右对齐
    display.setHorizontalAlignment(JTextField.RIGHT);
// 设置字体大小
    display.setFont(new Font("Arial", Font.PLAIN, 24));
// 添加到面板顶部
    panel.add(display, BorderLayout.NORTH);
// 创建按钮面板
    JPanel buttonPanel = new JPanel();
// 5行4列，间距5像素
    buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
// 数字按钮文本
    String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };
// 创建并添加按钮
    for (int i = 0; i < buttonLabels.length; i++) {
        String label = buttonLabels[i];
        JButton button = new JButton(label);
        if(label.matches("[0-9]")){
            button.setForeground(Color.BLACK);
        }else if (label.matches("[+\\-*/]")){
            button.setForeground(Color.RED);
        }else{
            button.setForeground(Color.GREEN);
        }
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.addActionListener(new ButtonClickListener());
        buttonPanel.add(button);
    }

// 设置按钮字体
// 添加点击监听器
// 添加到按钮面板

// 将按钮面板添加到主面板
// 将主面板添加到窗口
}

// 按钮点击事件监听器
// 获取按钮文本
// 数字按钮
// 运算符按钮
// 等号按钮
// 根据运算符计算结果
// 清空按钮

// 创建并显示计算器窗口
}
