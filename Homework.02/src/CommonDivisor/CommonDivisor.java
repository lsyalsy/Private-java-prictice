package CommonDivisor;
import java.util.Scanner;
//计算两个数的最大公约数
public class CommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(a + "与" + b + "的最大公约数为：" + gcd(a,b));
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
