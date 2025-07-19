package work3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] b = new boolean[1001];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            b[a] = true;
        }
        int count = 0;
        for(boolean judge : b){
            if(judge) count++;
        }
        System.out.println(count);
        for (int i = 0; i < 1001; i++) {
            if(b[i]){
                System.out.print(i + " ");
            }
        }

    }
}
