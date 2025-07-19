package test2;

import java.util.Scanner;

public class test4 {
    private static int count = 0;

    public static void hanoi(int n, char from, char temp, char to) {
        if (n == 1) {
            count++;
            return;
        }

        hanoi(n - 1, from, to, temp);
        count++;
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入汉诺塔的层数: ");
        int n = sc.nextInt();
        hanoi(n, 'A', 'B', 'C');
        System.out.println("总移动步数: " + count);
    }
}
