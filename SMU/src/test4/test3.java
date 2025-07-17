package test4;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[w + 1];
        Arrays.fill(dp, n); // 初始化
        dp[0] = 0; // 金额0需要0张纸币

        for (int i = 0; i < n; i++) {
            for(int j = a[i]; j <= w; j++){ // 正序循环
                dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
            }
        }

        System.out.println(dp[w]);
    }
}
