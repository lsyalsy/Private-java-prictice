package SliderProgress;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderProgressDemo {
    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("滑动与速度显示");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // 创建滑块
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 0);
        slider.setMajorTickSpacing(200);
        slider.setMinorTickSpacing(100);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // 创建进度条
        JProgressBar progressBar = new JProgressBar(0, 1000);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setString("0%");

        // 创建速度提示标签
        JLabel label = new JLabel("速度提示条");

        // 创建面板放置标签和进度条
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(progressBar);

        // 添加组件到窗口
        frame.add(slider, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // 添加滑块变化监听器
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                progressBar.setValue(value);
                progressBar.setString(value / 10 + "%"); // 转换为百分比显示
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }
}

