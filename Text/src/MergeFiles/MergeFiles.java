package MergeFiles;

import java.io.*;

public class MergeFiles {
    public static void main(String[] args) {
        String file1Path = "C:\\Users\\16677\\Desktop\\file1.txt";  // 第一个文件路径
        String file2Path = "C:\\Users\\16677\\Desktop\\file2.txt";  // 第二个文件路径
        String outputPath = "C:\\Users\\16677\\Desktop\\merged.txt"; // 合并后的文件路径

        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            // 读取并写入第一个文件内容
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // 保留换行符
            }

            // 可选：添加分隔线（如需分隔两个文件内容）
            // writer.write("--- 分隔线 ---");
            // writer.newLine();

            // 读取并写入第二个文件内容
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // 保留换行符
            }

            System.out.println("文件合并成功！结果保存至：" + outputPath);

        } catch (FileNotFoundException e) {
            System.out.println("错误：文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读写文件时发生错误");
            e.printStackTrace();
        }
    }
}

