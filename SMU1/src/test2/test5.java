package test2;
import java.util.Scanner;
public class test5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n + "的阶乘是: " + factorial(n));
    }

    // 递归计算阶乘
    public static long factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
