package Day01;
//write一维差分数组
import java.util.Scanner;
public class OneDDifference {
   static final int N = 100010;
   static int[] a = new int[N];
   static int[] b = new int[N];

   static void insert(int l, int r, int c){
       b[l] += c;
       b[r + 1] -= c;
   }

   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();

       for(int i = 1; i <= n; i++){
           a[i] = sc.nextInt();
           insert(i, i, a[i]);
       }

       while(m-- > 0){
           int l = sc.nextInt();
           int r = sc.nextInt();
           int c = sc.nextInt();
           insert(l, r, c);
       }

       for(int i = 1; i <= n; i++){
           a[i] = b[i] + a[i - 1];
           System.out.print(a[i] + " ");
       }
   }
}
