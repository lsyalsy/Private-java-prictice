package test2;

public class test1 {
    public static void main(String[] args) {
        int[][] a = new int[12][12];
        a[0][0] = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                a[i + 1][j] += a[i][j];
                a[i + 1][j + 1] += a[i][j];
            }
        }

        // 添加对齐输出
        for (int i = 0; i < 10; i++) {
            // 打印每行前面的空格
            for (int k = 0; k < 10 - i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", a[i][j]);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
