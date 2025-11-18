package Graph;

import java.util.Scanner;

enum GraphKind {
    DG,  // 有向图
    DN,  // 有向网
    UDG, // 无向图
    UDN  // 无向网
}

// 邻接矩阵表示的图类
class MGraph {
    GraphKind kind;         // 图的类型
    int vexNum;             // 顶点数
    int arcNum;             // 边数
    String[] vexs;          // 顶点信息数组
    int[][] arcs;           // 邻接矩阵
    int INFINITY = Integer.MAX_VALUE;  // 表示无穷大
}

public class GraphAdjMatrix {
    // 主函数，用于测试
    public static void main(String[] args) {
        MGraph G = new MGraph();
        boolean success = createGraph(G);
        if (success) {
            System.out.println("图创建成功！");
            // 这里可以添加打印图信息的代码
        } else {
            System.out.println("图创建失败！");
        }
    }

    // 创建图，根据不同的图类型调用不同的创建方法
    public static boolean createGraph(MGraph G) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入图的类型(DG/DN/UDG/UDN):");
        String kindStr = scanner.nextLine().toUpperCase();

        // 设置图的类型
        switch (kindStr) {
            case "DG":
                G.kind = GraphKind.DG;
                return createDG(G);
            case "DN":
                G.kind = GraphKind.DN;
                return createDN(G);
            case "UDG":
                G.kind = GraphKind.UDG;
                return createUDG(G);
            case "UDN":
                G.kind = GraphKind.UDN;
                return createUDN(G);
            default:
                return false; // ERROR
        }
    }

    // 创建有向图
    private static boolean createDG(MGraph G) {
        return createGraphCommon(G, false, false);
    }

    // 创建有向网
    private static boolean createDN(MGraph G) {
        return createGraphCommon(G, false, true);
    }

    // 创建无向图
    private static boolean createUDG(MGraph G) {
        return createGraphCommon(G, true, false);
    }

    // 创建无向网
    private static boolean createUDN(MGraph G) {
        return createGraphCommon(G, true, true);
    }

    // 通用的图创建方法
    private static boolean createGraphCommon(MGraph G, boolean isUndirected, boolean isWeighted) {
        Scanner scanner = new Scanner(System.in);

        // 输入顶点数和边数
        System.out.println("请输入顶点数:");
        G.vexNum = scanner.nextInt();
        System.out.println("请输入边数:");
        G.arcNum = scanner.nextInt();
        scanner.nextLine(); // 消费换行符

        // 初始化顶点信息数组
        G.vexs = new String[G.vexNum];
        System.out.println("请依次输入各顶点信息:");
        for (int i = 0; i < G.vexNum; i++) {
            G.vexs[i] = scanner.nextLine();
        }

        // 初始化邻接矩阵
        G.arcs = new int[G.vexNum][G.vexNum];
        for (int i = 0; i < G.vexNum; i++) {
            for (int j = 0; j < G.vexNum; j++) {
                if (i == j) {
                    G.arcs[i][j] = 0;
                } else {
                    G.arcs[i][j] = isWeighted ? G.INFINITY : 0;
                }
            }
        }

        // 输入边信息
        System.out.println("请依次输入各边的顶点i、顶点j(和权值，网图需要):");
        for (int k = 0; k < G.arcNum; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int weight = isWeighted ? scanner.nextInt() : 1;

            G.arcs[i][j] = weight;
            if (isUndirected) {
                G.arcs[j][i] = weight; // 无向图邻接矩阵对称
            }
        }

        return true;
    }
}
