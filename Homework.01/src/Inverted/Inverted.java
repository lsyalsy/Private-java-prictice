package Inverted;

import java.util.ArrayList;
import java.util.Scanner;
//倒序输出数字
public class Inverted {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        while(n > 0){
            list.add(n % 10);
            n /= 10;
        }
        System.out.print("倒序为：");
        for(int num : list){
            System.out.print(num);
        }
        sc.close();
    }
}
