package Day04;
import java.util.*;
public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1, 5, 11};
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 11);
        dp[0] = 0;
        for (int i = 0; i < a.length; i++) {
            for(int j = a[i]; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
