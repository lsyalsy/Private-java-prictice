package test;
import java.util.*;

public class chazi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long min = Long.MAX_VALUE;
        int i = 0, j = 0;
        while (i < n && j < n) {
            min = Math.min(min, Math.abs(a[i] - b[j]));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(min);
        sc.close();
    }
}
