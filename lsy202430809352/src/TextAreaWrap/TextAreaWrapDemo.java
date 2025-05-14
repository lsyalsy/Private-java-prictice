package TextAreaWrap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaWrapDemo extends JFrame {
    private JTextArea textArea;
    private JButton[] jbArray = new JButton[4];

    public TextAreaWrapDemo() {
        setTitle("文本区换行设置");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建文本区并添加到滚动面板
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(false); // 初始设置为不换行
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

        // 创建4个按钮并设置监听器
        String[] buttonLabels = {"自动换行", "不换行", "单词边界", "字符边界"};
        for (int i = 0; i < 4; i++) {
            jbArray[i] = new JButton(buttonLabels[i]);
            jbArray[i].addActionListener(new ButtonListener(i));
            buttonPanel.add(jbArray[i]);
        }

        // 添加组件到窗口
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        private int buttonIndex;

        public ButtonListener(int index) {
            this.buttonIndex = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (buttonIndex) {
                case 0: // 自动换行
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(false);
                    break;
                case 1: // 不换行
                    textArea.setLineWrap(false);
                    break;
                case 2: // 单词边界
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    break;
                case 3: // 字符边界
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(false);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAreaWrapDemo demo = new TextAreaWrapDemo();
            demo.setVisible(true);
        });
    }
}
