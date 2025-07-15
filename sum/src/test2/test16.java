package test2;

import java.util.Scanner;

public class test16 {
    static int R, C;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int ships = 0;
        boolean valid = true;

        for (int i = 0; i < R && valid; i++) {
            for (int j = 0; j < C && valid; j++) {
                if (grid[i][j] == '#' && !visited[i][j]) {
                    if (checkShip(i, j)) ships++;
                    else valid = false;
                }
            }
        }

        System.out.println(valid ? "There are " + ships + " ships." : "Bad placement.");
    }

    static boolean checkShip(int x, int y) {
        int x1 = x, y1 = y;
        while (x1 < R && grid[x1][y] == '#') x1++;
        while (y1 < C && grid[x][y1] == '#') y1++;

        for (int i = x; i < x1; i++) {
            for (int j = y; j < y1; j++) {
                if (grid[i][j] != '#' || visited[i][j]) return false;
                visited[i][j] = true;
            }
        }

        for (int i = x-1; i <= x1; i++) {
            for (int j = y-1; j <= y1; j++) {
                if (i >= 0 && i < R && j >= 0 && j < C &&
                    !(i >= x && i < x1 && j >= y && j < y1) &&
                    grid[i][j] == '#') return false;
            }
        }

        return true;
    }
}
