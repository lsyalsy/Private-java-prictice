package test3;

import java.util.Scanner;
// BrokenNecklaceDP - 解决环形项链分割问题
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();       // 项链珠子数量
        String necklace = scanner.next(); // 项链颜色序列

        // 定义四个DP数组：
        int[] leftR = new int[n];  // 从左到右，以当前位置结尾的最长连续红色(r/w)子串长度
        int[] leftB = new int[n];  // 从左到右，以当前位置结尾的最长连续蓝色(b/w)子串长度
        int[] rightR = new int[n]; // 从右到左，以当前位置开头的最长连续红色(r/w)子串长度
        int[] rightB = new int[n]; // 从右到左，以当前位置开头的最长连续蓝色(b/w)子串长度

        // ========== 从左向右预处理 ==========
        // 初始化第一个位置
        leftR[0] = (necklace.charAt(0) == 'r' || necklace.charAt(0) == 'w') ? 1 : 0;
        leftB[0] = (necklace.charAt(0) == 'b' || necklace.charAt(0) == 'w') ? 1 : 0;

        // 状态转移方程：
        // 当前字符是'r':
        //   leftR[i] = leftR[i-1] + 1 (红色串长度增加)
        //   leftB[i] = 0 (蓝色串中断)
        // 当前字符是'b':
        //   leftB[i] = leftB[i-1] + 1 (蓝色串长度增加)
        //   leftR[i] = 0 (红色串中断)
        // 当前字符是'w':
        //   leftR[i] = leftR[i-1] + 1 (可视为红色)
        //   leftB[i] = leftB[i-1] + 1 (可视为蓝色)
        for (int i = 1; i < n; i++) {
            char c = necklace.charAt(i);
            if (c == 'r') {
                leftR[i] = leftR[i - 1] + 1;
                leftB[i] = 0;
            } else if (c == 'b') {
                leftB[i] = leftB[i - 1] + 1;
                leftR[i] = 0;
            } else { // 'w' (wildcard)
                leftR[i] = leftR[i - 1] + 1;
                leftB[i] = leftB[i - 1] + 1;
            }
        }

        // ========== 从右向左预处理 ==========
        // 初始化最后一个位置
        rightR[n - 1] = (necklace.charAt(n - 1) == 'r' || necklace.charAt(n - 1) == 'w') ? 1 : 0;
        rightB[n - 1] = (necklace.charAt(n - 1) == 'b' || necklace.charAt(n - 1) == 'w') ? 1 : 0;

        // 状态转移方程(与从左向右类似，方向相反):
        // 当前字符是'r':
        //   rightR[i] = rightR[i+1] + 1
        //   rightB[i] = 0
        // 当前字符是'b':
        //   rightB[i] = rightB[i+1] + 1
        //   rightR[i] = 0
        // 当前字符是'w':
        //   rightR[i] = rightR[i+1] + 1
        //   rightB[i] = rightB[i+1] + 1
        for (int i = n - 2; i >= 0; i--) {
            char c = necklace.charAt(i);
            if (c == 'r') {
                rightR[i] = rightR[i + 1] + 1;
                rightB[i] = 0;
            } else if (c == 'b') {
                rightB[i] = rightB[i + 1] + 1;
                rightR[i] = 0;
            } else { // 'w'
                rightR[i] = rightR[i + 1] + 1;
                rightB[i] = rightB[i + 1] + 1;
            }
        }

        // ========== 计算最大可收集珠子数 ==========
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; // 环形处理，下一个位置
            // 关键组合公式：
            // 当前点左边最大长度(max(leftR[i], leftB[i])) +
            // 下一点右边最大长度(max(rightR[next], rightB[next]))
            int current = Math.max(leftR[i], leftB[i]) + Math.max(rightR[next], rightB[next]);
            max = Math.max(max, current);
        }
    }
}

        // 结果不能超过
