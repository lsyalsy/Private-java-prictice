package test1;
import java.util.Scanner;
public class test6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n + 2];
        int[][] op = new int[m][2];

        for(int i = 0; i < m; i++){
            op[i][0] = sc.nextInt();
            op[i][1] = sc.nextInt();
            d[op[i][0]]++;
            d[op[i][1] + 1]--;
        }

        int[] s = new int[n + 1];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            d[i] += d[i - 1];
            if(d[i] == 0){
                sum++;
            }
            s[i] = s[i - 1] + (d[i] == 1 ? 1 : 0);
        }

        for(int i = 0; i < m; i++){
            int l = op[i][0];
            int r = op[i][1];
            System.out.println(sum + (s[r] - s[l - 1]));
        }
    }
}