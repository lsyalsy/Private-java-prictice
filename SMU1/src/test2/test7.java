package test2;

import java.util.Scanner;

public class test7 {
    private static int n;
    private static int m;
    private static int[][] op;
    private static int[] count;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        op = new int[m][2];
        count = new int[n + 2];

        for (int i = 0; i < m; i++) {
            op[i][0] = sc.nextInt();
            op[i][1] = sc.nextInt();
        }

        dfs(0);
    }

    private static void dfs(int k) {
        if (k == m) {
            // 计算未被覆盖的点数
            int uncovered = 0;
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    uncovered++;
                }
            }
            System.out.println(uncovered);
            return;
        }

        // 不选第k个区间
        dfs(k + 1);

        // 选第k个区间
        for (int i = op[k][0]; i <= op[k][1]; i++) {
            count[i]++;
        }
        dfs(k + 1);
        for (int i = op[k][0]; i <= op[k][1]; i++) {
            count[i]--;
        }
    }
}
