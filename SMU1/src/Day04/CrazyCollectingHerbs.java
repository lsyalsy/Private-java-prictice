package Day04;
import java.util.*;
public class CrazyCollectingHerbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        long[] dp = new long[t + 1];
        dp[0] = 0;

        for(int i = 0; i < m; i++){
            for(int j = a[i]; j <= t; j++){
                dp[j] = Math.max(dp[j], dp[j - a[i]] + b[i]);
            }
        }
        System.out.println(dp[t]);
    }
}
