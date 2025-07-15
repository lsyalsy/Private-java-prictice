package test3;

import java.util.Scanner;
//LiBaiWine
public class test4 {
    static final int MOD = 1000000007; // 模数，防止结果过大

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 遇到店的次数
        int M = scanner.nextInt(); // 遇到花的次数

        // dp[i][j][k] 三维DP数组：
        // i - 已经遇到的店次数
        // j - 已经遇到的花次数
        // k - 当前酒壶中的酒量
        int[][][] dp = new int[N+1][M+1][M+1];

        // 初始状态：0次店，0次花，酒量为2的方案数为1
        dp[0][0][2] = 1;

        // 动态规划填表
        for (int i = 0; i <= N; i++) {         // 遍历店次数
            for (int j = 0; j <= M; j++) {     // 遍历花次数
                for (int k = 0; k <= M; k++) { // 遍历可能的酒量
                    if (i == 0 && j == 0) continue; // 跳过初始状态

                    // 状态转移方程1：最后一次遇到的是花
                    // 条件：还有花未遇到(j>0)且饮酒后酒量不会溢出(k+1 <= M)
                    // 转移：从dp[i][j-1][k+1]转移过来，表示遇到一次花，酒量减少1
                    if (j > 0 && k + 1 <= M) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i][j-1][k+1]) % MOD;
                    }

                    // 状态转移方程2：最后一次遇到的是店
                    // 条件：还有店未遇到(i>0)且当前酒量是偶数(k%2==0)
                    // 转移：从dp[i-1][j][k/2]转移过来，表示遇到一次店，酒量翻倍
                    if (i > 0 && k % 2 == 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k/2]) % MOD;
                    }
                }
            }
        }

        // 最终结果：遇到N次店，M-1次花，最后遇到一次花(酒量从1变为0)
        // 所以取dp[N][M-1][1]的值
        System.out.println(dp[N][M-1][1]);
    }
}
