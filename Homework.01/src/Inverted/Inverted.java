package Inverted;

import java.util.Scanner;
//倒序输出数字
public class Inverted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt(), count = 0;
        int[] arr = new int[22];
        if (n == 0) {
            System.out.println("0");
        }
        else {
            while (n > 0) {
                arr[count] = n % 10;
                n /= 10;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
        }
    }
}
