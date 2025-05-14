package W2_USB;

public class SoundCard implements USB{
    @Override
    public void start(){
        System.out.println("声卡启动...");
    }
    @Override
    public void stop(){
        System.out.println("声卡停止...");
    }
}
