package test1;
import java.util.*;
import java.io.*;
public class test3 {
    static final int N = 300010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[][] ops = new int[N][2];
    static int[] cnt = new int[N]; // 记录每个位置被覆盖的次数

    static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 读取所有操作并计算完整覆盖情况
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            ops[i][0] = Integer.parseInt(st.nextToken());
            ops[i][1] = Integer.parseInt(st.nextToken());
            insert(ops[i][0], ops[i][1], 1);
        }

        // 计算完整覆盖后的前缀和
        for(int i = 1; i <= n; i++) {
            a[i] = a[i-1] + b[i];
            cnt[i] = (a[i] == 1) ? 1 : 0;
            cnt[i] += cnt[i-1]; // 前缀和
        }

        // 处理每个操作被忽略的情况
        for(int j = 1; j <= m; j++) {
            int l = ops[j][0];
            int r = ops[j][1];
            // 计算移除该操作后变为0的位置数
            int zeros = cnt[r] - cnt[l-1];
            System.out.println(zeros);
        }
    }
}
