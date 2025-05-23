package work3CombineFiles;

import java.io.*;
import java.util.*;

public class CombineFiles {
    public static void main(String[] args) {
        try {
            // 创建两个输入流
            FileInputStream fis1 = new FileInputStream("prog1.java");
            FileInputStream fis2 = new FileInputStream("prog2.java");

            // 将输入流存入Vector
            Vector<InputStream> streams = new Vector<>();
            streams.add(fis1);
            streams.add(fis2);

            // 创建序列输入流
            SequenceInputStream seqStream = new SequenceInputStream(streams.elements());

            // 使用缓冲流提高读取效率
            BufferedInputStream bis = new BufferedInputStream(seqStream);

            // 读取并输出内容
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }

            // 关闭流
            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

