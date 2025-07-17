package Review;
import java.util.*;
import java.io.*;
public class GoodsRepertory {
    static int N = 300010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] s = new int[N];
    static int[][] op = new int[N][2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        //差分
        for(int i = 0; i < m; i++){
            String[] lr = br.readLine().split(" ");
            op[i][0] = Integer.parseInt(lr[0]);
            op[i][1] = Integer.parseInt(lr[1]);
            b[op[i][0]]++;
            b[op[i][1] + 1]--;
        }

        //前缀和还原数组
        int sum0 = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + b[i];
            if(a[i] == 0){
                sum0++;
            }
            s[i] = s[i - 1] + (a[i] == 1 ? 1 : 0);
        }

        for (int i = 0; i < m; i++) {
            int cur0 = sum0 + (s[op[i][1]] - s[op[i][0] - 1]);
            pw.println(cur0);
        }

        pw.flush();
    }
}
