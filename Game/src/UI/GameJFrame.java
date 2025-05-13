package UI;


import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame(){

        initJFrame();

        initJMenu();

    }

    private void initJMenu() {
        //菜单初始化
        //JMenuBar
        JMenuBar jMenuBar = new JMenuBar();
        //JMenu
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //JMenuItem
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //为界面设置菜单
        setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //页面初始化
        setSize(603, 680);
        setTitle("拼图游戏");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        //显示界面
        setVisible(true);
    }
}
