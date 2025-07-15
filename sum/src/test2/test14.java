package test2;

import java.util.Scanner;

public class test14 {
    static int n, m, horseX, horseY;
    static int[][] dirs = {{1, 0}, {0, 1}}; // 只能向下或向右
    static int[][] horseDirs = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };
    static boolean[][] blocked;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        horseX = sc.nextInt();
        horseY = sc.nextInt();

        blocked = new boolean[n + 1][m + 1];
        // 标记马的控制点
        blocked[horseX][horseY] = true;
        for (int[] dir : horseDirs) {
            int x = horseX + dir[0];
            int y = horseY + dir[1];
            if (x >= 0 && x <= n && y >= 0 && y <= m) {
                blocked[x][y] = true;
            }
        }

        dfs(0, 0);
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        if (x == n && y == m) {
            count++;
            return;
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx <= n && ny <= m && !blocked[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}

