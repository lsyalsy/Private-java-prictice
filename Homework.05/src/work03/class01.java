package work03;
import java.util.Scanner;

public class class01 {
    public static void sweap1(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("基础数据交换后：" + a + " " + b);
    }
    public static void sweap2(int[] arr1, int[] arr2){
        int temp = arr1[0];
        arr1[0] = arr2[0];
        arr2[0] = temp;
        System.out.println("数组首位数据交换后：" + arr1[0] + " " + arr2[0]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a的值：");
        int a = sc.nextInt();
        System.out.println("请输入b的值：");
        int b = sc.nextInt();
        sweap1(a, b);

        int[] arr1 = new int[1];
        int[] arr2 = new int[1];
        System.out.println("请输入arr1的值：");
        arr2[0] = sc.nextInt();
        System.out.println("请输入arr2的值：");
        arr2[0] = sc.nextInt();
        sweap2(arr1, arr2);
    }
}
