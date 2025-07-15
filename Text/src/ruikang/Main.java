package ruikang;
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] grid;
    static boolean[][] covered;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        covered = new boolean[n][m];

        // 读入矩阵
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 标记现有暖炉覆盖范围
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'm') {
                    markCovered(i, j);
                }
            }
        }

        // 识别异常水豚（未被覆盖的'w'）
        List<int[]> anomalies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'w' && !covered[i][j]) {
                    anomalies.add(new int[]{i, j});
                }
            }
        }

        // 无异常水豚且无冷豚：直接合法
        if (anomalies.isEmpty()) {
            boolean hasCold = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'c') hasCold = true;
                }
            }
            if (!hasCold) {
                System.out.println("Too cold!");
                return;
            }
        }

        // 检查隐藏暖炉位置
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && isValidPosition(i, j, anomalies)) {
                    candidates.add(new int[]{i, j});
                }
            }
        }

        // 输出结果
        if (candidates.isEmpty()) {
            System.out.println("Too cold!");
        } else {
            candidates.sort((a, b) ->
                    a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
            );
            for (int[] pos : candidates) {
                System.out.println((pos[0] + 1) + " " + (pos[1] + 1));
            }
        }
    }

    // 标记暖炉覆盖范围
    static void markCovered(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                covered[nx][ny] = true;
            }
        }
        covered[x][y] = true; // 自身位置
    }

    // 检查空格是否可放置暖炉
    static boolean isValidPosition(int x, int y, List<int[]> anomalies) {
        // 检查周围是否有冷豚（'c'）
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (grid[nx][ny] == 'c') return false;
            }
        }

        // 若无非异常水豚，无需检查
        if (anomalies.isEmpty()) return false;

        // 检查是否能覆盖至少一个异常水豚
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (grid[nx][ny] == 'w' && !covered[nx][ny]) {
                    return true;
                }
            }
        }
        return false;
    }
}

