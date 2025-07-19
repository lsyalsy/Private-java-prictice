package test2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//StrangeElevator
public class test13 {
    static int[] k; // 存储每层楼的移动步数
    static int n; // 总楼层数
    static boolean[] visited; // 记录楼层是否被访问过
    static int[] dist; // 记录到达每层楼的最短距离
    static int end; // 目标楼层

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int start = scanner.nextInt();
        end = scanner.nextInt();

        k = new int[n + 1]; // 楼层数组，下标从1开始
        dist = new int[n + 1];
        Arrays.fill(dist, -1); // 初始化距离为-1
        visited = new boolean[n + 1]; // 访问标记数组

        // 读取每层楼的移动步数
        for (int i = 1; i <= n; i++) {
            k[i] = scanner.nextInt();
        }

        // 执行BFS搜索
        bfs(start);

        // 输出结果
        System.out.println(dist[end]);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        dist[start] = 0; // 起始楼层按键次数为0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 尝试向上移动
            int up = current + k[current];
            if (up <= n && !visited[up]) {
                visited[up] = true;
                dist[up] = dist[current] + 1;
                queue.offer(up);
                if (up == end) return; // 找到目标楼层，直接返回
            }

            // 尝试向下移动
            int down = current - k[current];
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                dist[down] = dist[current] + 1;
                queue.offer(down);
                if (down == end) return; // 找到目标楼层，直接返回
            }
        }
    }
}

