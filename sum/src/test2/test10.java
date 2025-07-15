package test2;

import java.util.Scanner;


public class test10 {
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] s = new int[4];
        int[][] problems = new int[4][];

        // 读取输入
        for (int i = 0; i < 4; i++) {
            s[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            problems[i] = new int[s[i]];
            for (int j = 0; j < s[i]; j++) {
                problems[i][j] = scanner.nextInt();
            }
        }

        int totalTime = 0;

        // 处理每个科目
        for (int i = 0; i < 4; i++) {
            minTime = Integer.MAX_VALUE;
            dfs(problems[i], 0, 0, 0);
            totalTime += minTime;
        }

        System.out.println(totalTime);
    }

    // 递归函数：尝试将每个题目分配给左脑或右脑
    static void dfs(int[] problems, int index, int left, int right) {
        if (index == problems.length) {
            // 所有题目已分配，取左,右脑中的最大值
            int currentMax = Math.max(left, right);
            if (currentMax < minTime) {
                minTime = currentMax;
            }
            return;
        }

        // 将当前题目分配给左脑
        dfs(problems, index + 1, left + problems[index], right);

        // 将当前题目分配给右脑
        dfs(problems, index + 1, left, right + problems[index]);
    }
}
