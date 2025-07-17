package test4;
import java.util.Scanner;
public class Dtest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] volumes = new int[n];

        for (int i = 0; i < n; i++) {
            volumes[i] = sc.nextInt();
        }

        // 使用二维数组
        int[][] dp = new int[n + 1][V + 1];

        // 动态规划处理
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                if (j < volumes[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volumes[i - 1]] + volumes[i - 1]);
                }
            }
        }

        System.out.println(V - dp[n][V]);
    }
}
