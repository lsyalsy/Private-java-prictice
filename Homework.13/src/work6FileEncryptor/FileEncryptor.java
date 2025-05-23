package work6FileEncryptor;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileEncryptor {

    public static void encryptFile(String encodingFile, String encodedFile) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(encodingFile),
                                StandardCharsets.UTF_8
                        )
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(encodedFile),
                                StandardCharsets.UTF_8
                        )
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    encryptedLine.append(encryptChar(c));
                }
                writer.write(encryptedLine.toString());
                writer.newLine(); // 保留换行符
            }
        }
    }

    private static char encryptChar(char c) {
        if (Character.isDigit(c)) {
            return c == '9' ? '0' : (char) (c + 1);
        } else if (Character.isLetter(c)) {
            if (c == 'z') return 'a';
            if (c == 'Z') return 'A';
            return (char) (c + 1);
        }
        return c; // 非字母数字保持不变
    }

    // 测试用例
    public static void main(String[] args) {
        try {
            encryptFile("encodingFile.txt", "encodedFile.txt");
            System.out.println("文件加密完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
