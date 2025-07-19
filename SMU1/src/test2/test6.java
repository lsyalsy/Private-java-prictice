package test2;
import java.util.Scanner;
public class test6 {
    private static long[] memo; // 记忆化数组

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[n + 1]; // 初始化记忆数组
        System.out.println("第" + n + "个斐波那契数是: " + fibonacci(n));
    }

    // 带记忆化的递归计算斐波那契数
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n]; // 如果已经计算过，直接返回结果
        }
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2); // 存储计算结果
        return memo[n];
    }
}
