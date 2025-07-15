package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        System.out.println(bfs(maze, n, m));
    }

    public static int bfs(int[][] maze, int n, int m) {
        // 方向数组：上、右、下、左
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 距离数组，记录从起点到每个点的最短距离
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1; // 初始化为-1表示未访问
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 起点(0,0)
        dist[0][0] = 0; // 起点距离为0

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 遍历四个方向
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 检查新位置是否合法
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && maze[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});

                    // 如果到达终点，直接返回结果
                    if (nx == n - 1 && ny == m - 1) {
                        return dist[nx][ny];
                    }
                }
            }
        }

        return dist[n - 1][m - 1]; // 返回终点距离
    }
}
