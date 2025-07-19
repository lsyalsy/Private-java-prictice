package test;
import java.util.*;
public class Find {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = 0;
        while (true) {
            num = sc.nextInt();
            if(num == -1) break;
            boolean exsit = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == num) {
                    exsit = true;
                    break;
                }
            }
            if(exsit) {

                int left = 0, right = n - 1;
                while (left <= right) {
                    int mid = left + right >>> 1;
                    if (arr[mid] == num) {
                        left = mid;
                        break;
                    } else if (arr[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                System.out.print((left + 1) + " ");
            }else {
                System.out.println(0);
                break;
            }
        }
    }
}
