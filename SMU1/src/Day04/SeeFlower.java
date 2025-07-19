package Day04;
import java.util.*;

public class SeeFlower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 处理时间输入
        String[] start = sc.next().split(":");
        String[] end = sc.next().split(":");
        int n = sc.nextInt();

        int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        int totalTime = endTime - startTime;

        int[] dp = new int[totalTime + 1];

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int c = sc.nextInt();
            int p = sc.nextInt();

            if (p == 0) { // 完全背包
                for (int j = t; j <= totalTime; j++) {
                    dp[j] = Math.max(dp[j], dp[j - t] + c);
                }
            } else if (p == 1) { // 0-1背包
                for (int j = totalTime; j >= t; j--) {
                    dp[j] = Math.max(dp[j], dp[j - t] + c);
                }
            } else { // 多重背包
                for (int k = 1; k <= p; k++) {
                    for (int j = totalTime; j >= t; j--) {
                        dp[j] = Math.max(dp[j], dp[j - t] + c);
                    }
                }
            }
        }

        System.out.println(dp[totalTime]);
    }
}
