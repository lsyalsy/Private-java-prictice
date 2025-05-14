package USB;

public class MainBoard{
    public void startPCICard(USB usbDevice){
        usbDevice.start();
    }
    public void stopPCICard(USB usbDevice){
        usbDevice.stop();
    }
}
