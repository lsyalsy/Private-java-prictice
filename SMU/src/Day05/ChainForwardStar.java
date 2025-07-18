package Day05;
import java.util.*;
import java.io.*;
public class ChainForwardStar {
    // 合理调整 MAXN 和 MAXM 的值
    static final int MAXN = 1000005;
    static final int MAXM = 8000005;

    static int[] head = new int[MAXN];
    static int[] next = new int[MAXM];
    static int[] to = new int[MAXM];
    static int cnt = 0;
    static int[] weight = new int[MAXM];

    // 添加边的方法
    static void addEdge(int u, int v, int w) {
        to[cnt] = v;
        weight[cnt] = w;
        next[cnt] = head[u];
        head[u] = cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int flag = Integer.parseInt(st.nextToken());

        // 初始化 head 数组
        Arrays.fill(head, -1);

        // 读取边信息
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            addEdge(x, y, z);
            if (flag == 0) {
                // 无向图添加反向边
                addEdge(y, x, z);
            }
        }

        // 输出每个点的边信息
        for (int i = 1; i <= n; i++) {
            boolean hasEdge = false;
            for (int j = head[i]; j != -1; j = next[j]) {
                hasEdge = true;
                pw.println(i + " " + to[j] + " " + weight[j]);
            }
            if (!hasEdge) {
                // 该点无出边，输出空行
                pw.println();
            }
        }
        // 刷新输出缓冲区
        pw.flush();
        // 关闭资源
        pw.close();
        br.close();
    }
}
