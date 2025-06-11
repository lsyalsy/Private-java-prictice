package Divided;

import java.util.Scanner;
//判断一个数能否被9整除
public class Divided {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt(), sum = 0, num = n;
        while(num > 0){
            sum = num % 10;
            num /= 10;
        }
        if(sum % 9 == 0){
            System.out.println(n + "能被9整除");
        }else{
            System.out.println(n + "不能被9整除");
        }
        sc.close();
    }
}
