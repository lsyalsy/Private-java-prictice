package test;
import java.util.*;
public class ChooseClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] classNames = new String[n];
        double[][] time = new double[n][2];

        for (int i = 0; i < n; i++) {
            classNames[i] = sc.next();
            time[i][0] = sc.nextDouble();
            time[i][1] = sc.nextDouble();
        }

        Arrays.sort(time, (a, b) -> Double.compare(a[1], b[1]));

        int count = 0;
        double lastTime = 0;
        for(double[] t : time){
            if (t[0] >= lastTime) {
                count++;
                lastTime = t[1];
            }
        }
        System.out.println(count);
    }
}
