package W1_OneToN;

import java.util.Scanner;

public class OneToNDemo {
    public void display(OneToN Obj, int n){
        System.out.println("调用calculate方法的结果是：" + Obj.calculate(n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入整数：");
        int n = sc.nextInt();
        OneToNDemo oneToNDemo = new OneToNDemo();
        oneToNDemo.display(new Sum(), n);
        oneToNDemo.display(new Pro(), n);
    }
}
