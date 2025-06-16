package work02;
import java.util.Scanner;

public class Shapes {
    public static void main(String[] args){
        System.out.println("请输入要创建的三角形的个数n（n是大于0的整数）：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Triangle[] tg = new Triangle[n];
        for(int i = 0; i < n; i++){
            System.out.println("请输入第" + (i + 1) + "个三角形三条边的长度：");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a + b > c && a + c > b && b + c > a){
                Triangle t = new Triangle(a, b, c);
                t.computeArea(a, b, c);
                tg[i] = t;
                System.out.print(t.getArea() + " ");
            }else{
                System.out.println("您的输入不能构成一个三角形，请重新输入!");
                System.out.println("请输入第" + (i + 1) + "个三角形三条边的长度：");
            }
            if(i == n -1){
                System.out.println("已完成");
            }
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(tg[j].getArea() < tg[j + 1].getArea()){
                    Triangle temp = tg[j];
                    tg[j] = tg[j + 1];
                    tg[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println((i + 1) + " " + tg[i].getA() + " " + tg[i].getB() + " " + tg[i].getC() + " " + tg[i].getArea());
        }
    }
}
