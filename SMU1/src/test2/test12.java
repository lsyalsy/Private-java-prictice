package test2;

import java.util.*;
//ShortestPathBFS
public class test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 构建邻接表表示图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        int result = bfs(graph, 1, n);
        System.out.println(result);
    }

    private static int bfs(List<List<Integer>> graph, int start, int end) {
        if (start == end) return 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, -1);

        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;

                    if (neighbor == end) {
                        return distance[neighbor];
                    }

                    queue.offer(neighbor);
                }
            }
        }

        return -1;
    }
}
