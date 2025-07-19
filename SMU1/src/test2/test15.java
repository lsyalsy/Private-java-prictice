package test2;

import java.util.Scanner;

public class test15 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] used = new boolean[n + 1]; // 标记数字是否已使用
        backtrack(n, 1, used);

        System.out.println(count);
    }

    static void backtrack(int n, int pos, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i != pos && !used[i]) { // 不能放在原始位置且未被使用
                used[i] = true;
                backtrack(n, pos + 1, used);
                used[i] = false; // 回溯
            }
        }
    }
}

