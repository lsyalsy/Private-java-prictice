package test3;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 棋盘的行数/列数(N x N棋盘)
        int K = sc.nextInt();  // 需要放置的国王总数

        // 预处理所有合法行状态及其国王数
        List<Integer> states = new ArrayList<>();  // 存储所有合法的行状态
        List<Integer> counts = new ArrayList<>();   // 存储对应状态的国王数量

        // 遍历所有可能的状态(0到2^N-1)
        for (int mask = 0; mask < (1 << N); mask++) {
            // 检查状态是否合法: 没有相邻的1(国王不能相邻)
            if ((mask & (mask << 1)) == 0) {
                int cnt = Integer.bitCount(mask);  // 计算该状态下的国王数量
                states.add(mask);    // 添加合法状态
                counts.add(cnt);     // 添加对应的国王数
            }
        }

        int M = states.size();  // 合法状态的总数
        // DP数组: dp[i][j][k]表示前i行放置了j个国王，且第i行状态为k的方案数
        long[][][] dp = new long[N+1][K+1][1 << N];

        // 初始化: 第0行不放任何国王的方案数为1(基准情况)
        dp[0][0][0] = 1;

        // 动态规划处理每一行
        for (int i = 1; i <= N; i++) {          // 遍历每一行
            for (int j = 0; j <= K; j++) {      // 遍历可能的国王总数
                for (int currIdx = 0; currIdx < M; currIdx++) {  // 遍历当前行所有合法状态
                    int curr = states.get(currIdx);  // 当前行状态
                    int cnt = counts.get(currIdx);   // 当前行国王数

                    if (cnt > j) continue;  // 当前行国王数不能超过剩余可用国王数

                    // 遍历前一行的所有合法状态
                    for (int prevIdx = 0; prevIdx < M; prevIdx++) {
                        int prev = states.get(prevIdx);  // 前一行状态

                        // 检查两行状态是否兼容:
                        // 1. 垂直方向不能有冲突(上下不能有国王)
                        if ((curr & prev) != 0) continue;
                        // 2. 右上对角线不能有冲突
                        if ((curr & (prev << 1)) != 0) continue;
                        // 3. 左上对角线不能有冲突
                        if ((curr & (prev >> 1)) != 0) continue;

                        // 状态转移: 当前方案数 += 前一行的兼容方案数
                        dp[i][j][curr] += dp[i-1][j - cnt][prev];
                    }
                }
            }
        }

        // 统计所有第N行放置K个国王的方案数
        long ans = 0;
        for (int mask : states) {
            ans += dp[N][K][mask];  // 累加所有合法状态的方案数
        }

        System.out.println(ans);  // 输出最终结果
    }
}
