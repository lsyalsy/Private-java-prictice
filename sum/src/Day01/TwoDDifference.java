package Day01;
//write二维差分代码实现
import java.util.Scanner;
public class TwoDDifference {
    static final int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];


    static void insert(int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                a[i][j] = sc.nextInt();
                insert(i, j, i, j, a[i][j]);
            }
        }

        while(q-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
