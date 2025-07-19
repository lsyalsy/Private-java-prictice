package Day04;

import java.util.*;

public class PaperMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[w + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for(int j = a[i]; j <= w; j++){
                dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
            }
        }

        System.out.println(dp[w]);
    }
}
