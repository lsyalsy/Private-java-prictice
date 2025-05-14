package W2_USB;

public class ComputerDemo {
    public static void main(String[] args) {
        //创建主板对象
        MainBoard mainBoard = new MainBoard();
        //创建网卡对象
        NetworkCard networkCard = new NetworkCard();
        //启动网卡
        mainBoard.startPCICard(networkCard);
        //停止网卡
        mainBoard.stopPCICard(networkCard);
        //创建声卡对象
        SoundCard soundCard = new SoundCard();
        //启动声卡
        mainBoard.startPCICard(soundCard);
        //停止声卡
        mainBoard.stopPCICard(soundCard);
    }
}
