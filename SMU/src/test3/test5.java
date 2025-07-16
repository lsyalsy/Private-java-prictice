package test3;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt(); // 金字塔的行数
        int[][] pyramid = new int[r+1][r+1]; // 存储金字塔数据
        int[][] dp = new int[r+1][r+1];     // DP数组，存储从底部到当前位置的最大路径和

        // 读取输入数据，构建金字塔
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                pyramid[i][j] = scanner.nextInt(); // 读取每个位置的数字
            }
        }

        // 初始化最后一行（金字塔底部）
        // 最后一行没有子节点，最大和就是自身值
        for (int j = 1; j <= r; j++) {
            dp[r][j] = pyramid[r][j];
        }

        // 自底向上动态规划计算
        // 从倒数第二行开始向上计算
        for (int i = r-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                // 状态转移方程：
                // 当前位置的最大和 = 下方两个子节点中较大的值 + 当前节点的值
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + pyramid[i][j];
            }
        }

        // 输出结果：金字塔顶部的最大路径和
        System.out.println(dp[1][1]); // 修正了原代码中的语法错误(@ref)
    }
}

