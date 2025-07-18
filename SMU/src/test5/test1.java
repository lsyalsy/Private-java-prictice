package test5;

import java.util.Scanner;

// 边的结构体
class Edge {
    int to;  // 边的终点
    int next; // 下一条同起点的边的编号
    int w;  // 边的权重
}

public class test1 {
    static final int MAXN = 1000005;
    static final int MAXM = 4000005;
    static int n, m, flag;
    static int[] head = new int[MAXN]; // 头数组，存储每个点的第一条边的编号
    static Edge[] edges = new Edge[MAXM];
    static int cnt = 0; // 边的编号

    // 添加边的函数
    static void addEdge(int u, int v, int w) {
        edges[cnt] = new Edge();
        edges[cnt].to = v;
        edges[cnt].w = w;
        edges[cnt].next = head[u];
        head[u] = cnt++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        flag = scanner.nextInt();

        // 初始化头数组
        for (int i = 1; i <= n; i++) {
            head[i] = -1;
        }

        // 读入边的信息
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            addEdge(x, y, z);
            if (flag == 0) {
                addEdge(y, x, z);
            }
        }

        // 输出边的信息
        for (int i = 1; i <= n; i++) {
            boolean hasEdge = false;
            for (int j = head[i]; j != -1; j = edges[j].next) {
                hasEdge = true;
                System.out.println(i + " " + edges[j].to + " " + edges[j].w);
            }
            if (!hasEdge) {
                System.out.println();
            }
        }
        scanner.close();
    }
}
