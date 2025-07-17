package Day04;
import java.util.*;

public class PaperMoney2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int MOD = 1000000007;
        int[] dp = new int[w + 1];
        dp[0] = 1;

        // 排列问题：先遍历金额，再遍历物品
        for (int i = 1; i <= w; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= a[j]) {
                    dp[i] = (dp[i] + dp[i - a[j]]) % MOD;
                }
            }
        }

        System.out.println(dp[w]);
    }
}
