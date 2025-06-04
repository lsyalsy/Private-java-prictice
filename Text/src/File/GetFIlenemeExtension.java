package File;

import java.io.File;

public class GetFIlenemeExtension {
    public static void main(String[] args) {
        String fileName = "TestString.class";
        int dotIndex = fileName.lastIndexOf(".");
        String fileExtension = fileName.substring(dotIndex);
        System.out.println(fileExtension);
    }
}
