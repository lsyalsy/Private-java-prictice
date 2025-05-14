package Culcalator01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Culcalator extends JFrame {
    // 显示输入输出的文本框
    private JTextField display;
    // 存储当前输入的数字
    private String currentInput = "";
    // 存储第一个操作数
    private double firstOperand = 0;
    // 存储当前运算符
    private String currentOperator = "";
    // 标记是否开始新的输入
    private boolean newInput = true;

    public Culcalator() {
        // 设置窗口标题
        setTitle("简单计算器");
        // 设置窗口大小
        setSize(300, 400);
        // 设置窗口关闭行为
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口居中显示
        setLocationRelativeTo(null);

        // 创建主面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建显示文本框
        display = new JTextField();
        display.setEditable(false); // 设置为不可编辑
        display.setHorizontalAlignment(JTextField.RIGHT); // 文本右对齐
        display.setFont(new Font("Arial", Font.PLAIN, 24)); // 设置字体大小
        panel.add(display, BorderLayout.NORTH); // 添加到面板顶部

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5行4列，间距5像素

        // 数字按钮文本
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // 创建并添加按钮
        for (String label : buttonLabels) {
            JButton button = new JButton(label);

            // 设置按钮颜色
            if (label.matches("[0-9]")) {
                button.setForeground(Color.BLACK); // 数字按钮黑色
            } else if (label.matches("[+\\-*/]")) {
                button.setForeground(Color.RED); // 运算符按钮红色
            } else {
                button.setForeground(Color.GREEN); // 其他按钮绿色
            }

            button.setFont(new Font("Arial", Font.BOLD, 18)); // 设置按钮字体
            button.addActionListener(new ButtonClickListener()); // 添加点击监听器
            buttonPanel.add(button); // 添加到按钮面板
        }

        panel.add(buttonPanel, BorderLayout.CENTER); // 将按钮面板添加到主面板
        add(panel); // 将主面板添加到窗口
    }

    // 按钮点击事件监听器
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // 获取按钮文本

            if (command.matches("[0-9]")) { // 数字按钮
                if (newInput) {
                    currentInput = command;
                    newInput = false;
                } else {
                    currentInput += command;
                }
                display.setText(currentInput);
            }
            else if (command.matches("[+\\-*/]")) { // 运算符按钮
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                }
                currentOperator = command;
                newInput = true;
            }
            else if (command.equals("=")) { // 等号按钮
                if (!currentOperator.isEmpty() && !currentInput.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = 0;

                    // 根据运算符计算结果
                    switch (currentOperator) {
                        case "+":
                            result = firstOperand + secondOperand;
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            break;
                        case "/":
                            if (secondOperand != 0) {
                                result = firstOperand / secondOperand;
                            } else {
                                display.setText("错误");
                                return;
                            }
                            break;
                    }

                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    newInput = true;
                    currentOperator = "";
                }
            }
            else if (command.equals("C")) { // 清空按钮
                currentInput = "";
                firstOperand = 0;
                currentOperator = "";
                newInput = true;
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // 创建并显示计算器窗口
        SwingUtilities.invokeLater(() -> {
            Culcalator calculator = new Culcalator();
            calculator.setVisible(true);
        });
    }
}
