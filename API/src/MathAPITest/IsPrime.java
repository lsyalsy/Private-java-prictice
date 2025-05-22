package MathAPITest;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isprime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
            {
                isprime = false;
            }
        }
        if(isprime)
        {
            System.out.println("是质数");
        }else {
            System.out.println("不是质数");
        }
    }
}
