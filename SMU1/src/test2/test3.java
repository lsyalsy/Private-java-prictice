package test2;
import java.util.Scanner;
public class test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] x = {-2,-2,-1,-1,1,1,2,2};
        int[] y = {-1,1,-2,2,-2,2,-1,1};
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        a[n-1][m-1] = -1;  // 修正数组越界问题

        // 标记障碍点
        for(int i = 0; i < 8; i++){
            int nx = (n-1) + x[i];  // 修正索引从0开始
            int ny = (m-1) + y[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && i >= 2){
                a[nx][ny] = -1;
            }
        }

        // 添加路径检查逻辑
        boolean canReach = true;
        for(int i = 0; i < 8; i++){
            int nx = (n-1) + x[i];
            int ny = (m-1) + y[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] != -1){
                // 有可达路径
                canReach = true;
                break;
            }
        }

        System.out.println(canReach ? "可以到达" : "无法到达");
    }
}
