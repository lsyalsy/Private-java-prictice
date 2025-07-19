package Day05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoodChain {
    static final int MOD = 80112002;
    static final int MAXN = 5005;
    static final int MAXM = 500005;

    static int[] head = new int[MAXN];
    static int[] to = new int[MAXM];
    static int[] next = new int[MAXM];
    static  int cnt = 0;

    static int[] inDegree = new int[MAXN];
    static int[] outDegree = new int[MAXN];
    static int[] dp = new int[MAXN];

    static void addEdge(int u, int v){
        to[cnt] = v;
        next[cnt] = head[u];
        head[u] = cnt++;
        inDegree[v]++;
        outDegree[u]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Arrays.fill(head, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a,b);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                dp[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int i = head[u]; i != -1; i = next[i]){
                int v = to[i];
                inDegree[v]--;
                dp[v] = (dp[u] + dp[v]) % MOD;
                if(inDegree[v] == 0){
                    queue.offer(v);
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= m; i++){
            if(outDegree[i] == 0 ){
                result = (result + dp[i]) % MOD;
            }
        }
        System.out.println(result);
    }
}
