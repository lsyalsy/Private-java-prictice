package test1;
import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] marr = new int[m][4];
        for (int i = 0; i < m; i++) {
            marr[i][0] = sc.nextInt();
            marr[i][1] = sc.nextInt();
            marr[i][2] = sc.nextInt();
            marr[i][3] = sc.nextInt();
        }

        int[][] point = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x1 = marr[i][0];
            int y1 = marr[i][1];
            int x2 = marr[i][2];
            int y2 = marr[i][3];
            point[x1][y1]++;
            point[x2][y2]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(point[i][j]);
                if(j != n-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
