package Book;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad extends JFrame {
    private JTextArea textArea;
    private Clipboard clipboard;

    public Notepad() {
        setTitle("简易记事本");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // 初始化剪贴板
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("编辑");

        // 查找菜单项
        JMenuItem findItem = new JMenuItem("查找");
        findItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = JOptionPane.showInputDialog(Notepad.this, "输入查找内容:");
                if (findText != null && !findText.isEmpty()) {
                    String text = textArea.getText();
                    int index = text.indexOf(findText);
                    if (index != -1) {
                        textArea.setCaretPosition(index);
                        textArea.select(index, index + findText.length());
                    } else {
                        JOptionPane.showMessageDialog(Notepad.this, "未找到内容");
                    }
                }
            }
        });

        // 替换菜单项
        JMenuItem replaceItem = new JMenuItem("替换");
        replaceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = JOptionPane.showInputDialog(Notepad.this, "输入查找内容:");
                String replaceText = JOptionPane.showInputDialog(Notepad.this, "输入替换内容:");
                if (findText != null && !findText.isEmpty() && replaceText != null) {
                    String text = textArea.getText();
                    text = text.replace(findText, replaceText);
                    textArea.setText(text);
                }
            }
        });

        // 复制菜单项
        JMenuItem copyItem = new JMenuItem("复制");
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                if (selectedText != null) {
                    StringSelection selection = new StringSelection(selectedText);
                    clipboard.setContents(selection, null);
                }
            }
        });

        // 粘贴菜单项
        JMenuItem pasteItem = new JMenuItem("粘贴");
        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transferable content = clipboard.getContents(null);
                if (content != null && content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String text = (String) content.getTransferData(DataFlavor.stringFlavor);
                        textArea.replaceRange(text, textArea.getSelectionStart(), textArea.getSelectionEnd());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        editMenu.add(findItem);
        editMenu.add(replaceItem);
        editMenu.addSeparator();
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Notepad());
    }
}
