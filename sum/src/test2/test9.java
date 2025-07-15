package test2;

import java.util.Scanner;

public class test9 {
    // 定义8个方向的偏移量
    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                String line = scanner.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            System.out.println(countOilDeposits(grid));
        }

        scanner.close();
    }

    private static int countOilDeposits(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] != '@' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // 遍历8个方向
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], visited);
        }
    }
}

