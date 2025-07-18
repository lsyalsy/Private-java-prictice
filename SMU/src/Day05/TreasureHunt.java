package Day05;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }
        int p = scanner.nextInt();
        int[] treasures = new int[p];
        for (int i = 0; i < p; i++) {
            treasures[i] = scanner.nextInt();
        }

        int maxState = 1 << p;
        int[][] dp = new int[maxState][n + 1];
        // 初始化 dp 数组为一个较大的值
        for (int i = 0; i < maxState; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        // 从 1 号区域出发
        if (hasTreasure(1, treasures)) {
            int initState = getState(1, treasures);
            dp[initState][1] = 0;
        } else {
            dp[0][1] = 0;
        }

        // 状态转移
        for (int state = 0; state < maxState; state++) {
            for (int i = 1; i <= n; i++) {
                if (dp[state][i] == Integer.MAX_VALUE / 2) continue;
                for (int j = 1; j <= n; j++) {
                    int newState = state;
                    if (hasTreasure(j, treasures)) {
                        newState |= getState(j, treasures);
                    }
                    dp[newState][j] = Math.min(dp[newState][j], dp[state][i] + dist[i][j]);
                }
            }
        }

        // 计算结果
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[maxState - 1][i] + dist[i][n]);
        }

        System.out.println(ans);
        scanner.close();
    }

    // 判断某个区域是否有宝藏
    private static boolean hasTreasure(int area, int[] treasures) {
        for (int t : treasures) {
            if (t == area) return true;
        }
        return false;
    }

    // 获取某个区域对应的状态位
    private static int getState(int area, int[] treasures) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == area) {
                return 1 << i;
            }
        }
        return 0;
    }
}
