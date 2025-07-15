package test1;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w0 = scanner.nextInt();
        int w = scanner.nextInt();
        int m = scanner.nextInt();

        double monthlyRate = calculateMonthlyRate(w0, w, m);
        double annualRate = monthlyRate * 12 * 100; // 转换为年利率百分比

        System.out.printf("月利率: %.6f%%\n", monthlyRate * 100);
        System.out.printf("年利率: %.6f%%\n", annualRate);
    }

    // 二分法计算月利率
    public static double calculateMonthlyRate(double w0, double w, int m) {
        double left = 0.00001;
        double right = 1.0;
        double precision = 1e-8;

        while (right - left > precision) {
            double mid = (left + right) / 2;
            double sum = calculatePresentValue(w, m, mid);

            if (sum < w0) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return (left + right) / 2;
    }

    // 计算给定利率下的现值总和
    private static double calculatePresentValue(double w, int m, double r) {
        double sum = 0.0;
        for (int i = 1; i <= m; i++) {
            sum += w / Math.pow(1 + r, i);
        }
        return sum;
    }
}
