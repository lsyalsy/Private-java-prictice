package work2;
import java.util.Scanner;
public class Main {
    static char[][] position = new char[105][105];
    static int n , m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         sc.nextLine();
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(position[i][j] != '*'){
                    System.out.print(judge(i,j));
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static int judge(int x, int y){
        int number = 0;
        int[][] p = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},         {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int i = 0; i < 8; i++) {
            int nx = p[i][0] + x;
            int ny = p[i][1] + y;
            if( nx >= 0 && nx < n && ny >= 0 && ny < m && position[nx][ny] == '*'){
                number++;
            }
        }
        return number;
    }
}
