package Day03;
import java.util.Scanner;

public class MinBoatRent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] r = new int[n+1][n+1]; // 租金矩阵，1-based索引
        int[] dp = new int[n+1]; // dp数组

        // 读取输入数据
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                r[i][j] = scanner.nextInt();
            }
        }

        // 初始化dp数组
        dp[1] = 0; // 起点租金为0
        for (int i = 2; i <= n; i++) {
            dp[i] = r[1][i]; // 初始化为直接从1到i的租金
        }

        // 动态规划计算最小租金
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (dp[i] > dp[j] + r[j][i]) {
                    dp[i] = dp[j] + r[j][i];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
