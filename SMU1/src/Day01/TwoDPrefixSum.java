package Day01;
//write二维前缀和代码实现
import java.util.Scanner;
public class TwoDPrefixSum {
    static final int N = 1010;
    static int[][] s = new int[N][N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                s[i][j] = sc.nextInt();
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }

        while(q-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int sum = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
            System.out.println(sum);
        }
    }
}