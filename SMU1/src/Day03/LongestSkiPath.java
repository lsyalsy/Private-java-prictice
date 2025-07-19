package Day03;

import java.util.Scanner;
public class LongestSkiPath{
    static int R, C;
    static int[][] grid;
    static int[][] dp;
    public static void main(String[] args){
        //输入
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new int[R][C];
        dp = new int[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        //主循环遍历调用DFS判断每个位置的长度
        int maxd = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                dp[i][j] = dfs(i, j);
                maxd = Math.max(dp[i][j], maxd);
            }
        }
        //输出
        System.out.println(maxd);
    }

    //DFS，初始化dp数组，四个方向搜索，接收坐标，判断是否被查询过，如果是就直接返回，如果不是，先初始化为1，然后查询，同时存储本次运算结果，返回该坐标的最远距离
    static int dfs(int x, int y){
        int[][] dir = {
                {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];

            if(nx >= 0 && ny >= 0 && nx < R && ny < C && grid[nx][ny] < grid[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
            }
        }

        return dp[x][y];
    }
}