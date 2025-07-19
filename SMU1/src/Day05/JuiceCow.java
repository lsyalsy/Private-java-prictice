package Day05;
import java.util.*;
public class JuiceCow {
    static final int MAXN = 100005;
    static final int MAXM = 10000005;
    static int[] head = new int[MAXN];
    static int[] next = new int[MAXN];
    static int[] to = new int[MAXN];
    static int cnt = 0;

    static int[] time = new int[MAXN];
    static int[] indegree = new int[MAXN];
    static int[] earlistTime = new int[MAXN];
    static int[] queue = new int[MAXN];

    static void addEdge(int u, int v){
        to[cnt] = v;
        next[cnt] = head[u];
        head[u] = cnt++;
        indegree[v]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(head, -1);

        for (int i = 1; i <= n; i++) {
            int taskId = sc.nextInt();
            time[taskId] = sc.nextInt();
            int pretask;
            while((pretask = sc.nextInt()) != 0){
                addEdge(pretask, taskId);
            }
        }

        int l = 0;
        int r = 0;
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue[r++] = i;
                earlistTime[i] = time[i];
            }
        }

        while(l < r){
            int currentTask = queue[l++];
            for(int i = head[currentTask]; i != -1; i = next[i]){
                int nextTask = to[i];
                indegree[nextTask]--;
                earlistTime[nextTask] = Math.max(earlistTime[nextTask], earlistTime[currentTask] + time[nextTask]);
                if(indegree[nextTask] == 0){
                    queue[r++] = nextTask;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, earlistTime[i]);
        }

        System.out.println(result);

    }


}
