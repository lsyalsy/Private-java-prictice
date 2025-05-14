package MoveMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveMessageDemo extends JFrame {
    private String message = "Welcome to Java";
    private int x = 20;
    private int y = 100;
    private int direction = 1; // 1 for right, -1 for left
    private final int STEP = 5;

    public MoveMessageDemo() {
        setTitle("MoveMessageDemo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += STEP * direction;

                // Reverse direction when hitting the edges
                if (x > getWidth() - 50) {
                    direction = -1;
                } else if (x < 20) {
                    direction = 1;
                }

                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(message, x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MoveMessageDemo demo = new MoveMessageDemo();
            demo.setVisible(true);
        });
    }
}
