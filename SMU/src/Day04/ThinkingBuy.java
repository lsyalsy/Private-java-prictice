package Day04;
import java.util.*;
public class ThinkingBuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[m];
        int[] product = new int[m];

        for (int i = 0; i < m; i++) {
            v[i] = sc.nextInt();
            int p = sc.nextInt();
            product[i] = v[i] * p;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            for(int j = n; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - v[i]] + product[i]);
            }
        }

        System.out.println(dp[n]);


    }
}
