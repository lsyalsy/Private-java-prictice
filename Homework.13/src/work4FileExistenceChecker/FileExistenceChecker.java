package work4FileExistenceChecker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExistenceChecker {
    public static void main(String[] args) {
        // 要检查的文件路径（请替换为实际路径）
        String filePath = "prog2.java";

        // 创建File对象
        File targetFile = new File(filePath);

        // 使用File类方法检查文件存在性
        if (targetFile.exists() && targetFile.isFile()) {
            System.out.println("文件存在，准备创建流...");

            try {
                // 创建输入流示例
                FileInputStream fis = new FileInputStream(targetFile);
                System.out.println("输入流创建成功");
                fis.close();

                // 创建输出流示例
                FileOutputStream fos = new FileOutputStream(targetFile);
                System.out.println("输出流创建成功");
                fos.close();

            } catch (IOException e) {
                System.err.println("流创建失败：" + e.getMessage());
            }
        } else {
            System.out.println("文件不存在或路径指向目录");
        }
    }
}
