package work7CommentRemover;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CommentRemover {
    public void removeComments(File javaFile) {
        try {
            // 读取文件所有行
            List<String> lines = Files.readAllLines(javaFile.toPath(), StandardCharsets.UTF_8);

            // 过滤以//开头的行（允许前导空格）
            List<String> filteredLines = lines.stream()
                    .filter(line -> !line.trim().startsWith("//"))
                    .collect(Collectors.toList());

            // 写回原文件
            Files.write(javaFile.toPath(), filteredLines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
