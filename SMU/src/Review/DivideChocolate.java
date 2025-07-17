package Review;
import java.util.Scanner;
public class DivideChocolate {
    static int n, k;
    static int[][] chocolates;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        chocolates = new int[n][2];

        for (int i = 0; i < n; i++) {
            chocolates[i][0] = sc.nextInt();
            chocolates[i][1] = sc.nextInt();
        }
        //二分查找
        int left = 1, right = 100000;
        int result = 0;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(cancut(mid)){
                result = mid;
                left = mid + 1;
            }else right = mid - 1;
        }
        System.out.println(result);
    }

    static boolean cancut(int sidelength){
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (chocolates[i][0] / sidelength) * (chocolates[i][1] / sidelength);
            if(count >= k) return true;
        }
        return false;
    }
}
