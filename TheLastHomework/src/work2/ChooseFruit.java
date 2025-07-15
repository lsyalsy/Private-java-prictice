package work2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChooseFruit {
    public static void main(String[] args){
        //页面框架
        JFrame frame = new JFrame("水果选择页面");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 1));

        //创建标签
        JLabel label = new JLabel("请选择水果:");

        //创建列表
        String[] fruits = {"苹果" , "香蕉", "橙子"};
        JComboBox<String> fruitList = new JComboBox<>(fruits);

        //创建文本框
        JTextField resultFruit = new JTextField();
        resultFruit.setEditable(false);

        //创建列表的事件监听器
        fruitList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedFruit = (String)fruitList.getSelectedItem();
                System.out.println("你选择了" + selectedFruit);
                resultFruit.setText("你选择了" + selectedFruit);
            }
        });

        //添加组件到frame
        frame.add(label);
        frame.add(fruitList);
        frame.add(resultFruit);

        //设置可见
        frame.setVisible(true);
    }
}
