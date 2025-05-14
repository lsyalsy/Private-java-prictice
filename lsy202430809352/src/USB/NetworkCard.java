package USB;

public class NetworkCard implements USB{
    @Override
    public void start() {
        System.out.println("网卡启动...");
    }

    @Override
    public void stop() {
        System.out.println("网卡关闭...");
    }

}
