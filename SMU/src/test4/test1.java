package test4;
import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();  // 箱子容量
        int n = sc.nextInt();  // 物品数量
        int[] volumes = new int[n];  // 物品体积数组

        for (int i = 0; i < n; i++) {
            volumes[i] = sc.nextInt();
        }
        
        // 使用一维数组优化空间复杂度
        int[] dp = new int[V + 1];

        // 动态规划处理
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= volumes[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - volumes[i]] + volumes[i]);
            }
        }

        // 输出最小剩余空间
        System.out.println(V - dp[V]);
    }
}
