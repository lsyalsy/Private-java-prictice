package Day04;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] ts = sc.next().split(":");
        String[] te = sc.next().split(":");

        int startTime = Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);
        int endTime = Integer.parseInt(te[0]) * 60 + Integer.parseInt(te[1]);
        int Time = endTime - startTime;

        int n = sc.nextInt();
        int[] dp = new int[Time + 1];

        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            int c = sc.nextInt();
            int p = sc.nextInt();

            //完全背包
            if(p == 0){
                for(int j = t; j <= Time; j++){
                    dp[j] = Math.max(dp[j], dp[j - t] + c);
                }
            }
            //0-1背包
            if(p == 1){
                for(int j = Time; j >= t; j--){
                    dp[j] = Math.max(dp[j], dp[j - t] + c);
                }
            }
            //多重背包（p个0-1背包）
            if(p > 1){
                for(int k = 0; k < p; k++){
                    for(int j = Time; j >= t; j--){
                        dp[j] = Math.max(dp[j], dp[j - t] + c);
                    }
                }
            }
        }
        System.out.println(dp[Time]);
    }
}