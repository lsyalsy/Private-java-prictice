package test2;

import java.util.Scanner;

public class test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 错位排列的递推公式：D(n) = (n-1)*(D(n-1)+D(n-2))
        long[] dp = new long[n + 1];
        dp[1] = 0;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        System.out.println(dp[n]);
    }
}
