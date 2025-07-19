package work6;

import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static int[][] minefield = new int[1010][1010];
    static boolean[][] visited = new boolean[1010][1010];
    static int[][] directions = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1}        ,{0,1},
            {1,-1},{1,0}  ,{1,1}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                minefield[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int vb3 = calculate3BV();
        System.out.println(vb3);
    }

    static int calculate3BV(){
        int num1 = 0;
        int num2 = 0;

        boolean[][] isSpace = new boolean[n][m];
        boolean[][] isDigit = new boolean[n][m];
//标记空格和数字
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(minefield[i][j] == 0){
                    int mineCount = countAdjacentMines(i,j);
                    if(mineCount == 0){
                        isSpace[i][j] = true;
                    }else {
                        isDigit[i][j] = true;
                    }
                }
            }
        }
//计算空的个数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isSpace[i][j] && !visited[i][j]){
                    dfs(i, j, isSpace);
                    num2++;
                }
            }
        }
//计算周围八格没有空格的数字
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isDigit[i][j] & !hasAdjacentSpaces(i, j, isSpace)){
                    num1++;
                }
            }
        }

        return num1 + num2;
    }

    static int countAdjacentMines(int x, int y){
        int count = 0;
        for(int[] dir : directions){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(isValid(nx, ny) && minefield[nx][ny] == 1){
                count++;
            }
        }
        return count;
    }

    static void dfs(int x, int y, boolean[][] isSpace){
        if(!isValid(x, y) || !isSpace[x][y] || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int[] dir : directions){
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(nx, ny, isSpace);
        }
    }

    static boolean hasAdjacentSpaces(int x, int y, boolean[][] isSpace){
        for(int[] dir : directions){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(isValid(nx, ny) && isSpace[nx][ny]){
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}