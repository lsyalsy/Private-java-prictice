package USB;

public class ComputerDemon {
    public static void main(String[] args) {
        MainBoard mainBoard = new MainBoard();
        NetworkCard networkCard = new NetworkCard();
        mainBoard.startPCICard(networkCard);
        mainBoard.stopPCICard(networkCard);
        SoundCard soundCard = new SoundCard();
        mainBoard.startPCICard(soundCard);
        mainBoard.stopPCICard(soundCard);
    }
}
