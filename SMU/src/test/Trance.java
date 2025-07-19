package test;
import java.util.Scanner;
public class Trance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char c = sc.next().charAt(0);

        System.out.printf("(%d)+(%d)",n,m);
    }
}
