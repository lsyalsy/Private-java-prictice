package test4;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int M = sc.nextInt();
        int[] time = new int[M];
        int[] value = new int[M];

        for (int i = 0; i < M; i++) {
            time[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[T + 1];  // 修正数组大小

        for (int i = 0; i < M; i++) {  // 遍历所有草药
            for(int j = T; j >= time[i]; j--) {  // 倒序更新
                dp[j] = Math.max(dp[j], dp[j - time[i]] + value[i]);  // 比较价值
            }
        }

        System.out.println(dp[T]);
    }
}
