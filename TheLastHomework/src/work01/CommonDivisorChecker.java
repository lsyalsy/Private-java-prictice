package work01;
import java.util.Scanner;

public class CommonDivisorChecker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        if(isPrime(n)){
            System.out.println(n + "没有公约数");
        }else{
            System.out.println(n + "有公约数");
        }

    }

    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;

        for(int i = 3; i < Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
