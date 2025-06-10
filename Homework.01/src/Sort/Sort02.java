package Sort;

import java.util.Arrays;
import java.util.Scanner;

//使用Arrays.sort方法排序数组
public class Sort02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入四个整数：");
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 3; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
