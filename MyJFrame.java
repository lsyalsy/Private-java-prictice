@Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == GoodButton) {
        System.out.println("你是一个好人");
    } else if (source == NormalButton) {
        System.out.println("普通帅");
    } else if (source == badButton) {
        System.out.println("不太帅");
    }
}
