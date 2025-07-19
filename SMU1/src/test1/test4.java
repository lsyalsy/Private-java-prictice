package test1;

import java.util.Scanner;
public class test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];  // 改为n而不是n+1

        for(int i = 0; i < n; i++){  // 从0开始存储
            p[i] = sc.nextInt();
        }
        int first = sc.nextInt();  // 单独存储第一个元素

        int current = first;
        while(current != 0){
            System.out.print(current + " ");
            current = p[current - 1];  // 调整索引
        }
    }
}