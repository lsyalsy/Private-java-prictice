package MathAPITest;

import java.util.Scanner;

public class TowdataZhiMiShu {
    public static void main(String[] args) {
        double a, sum, ge, shi;
        int  count = 0;
        for (a = 1; a < 100; a++) {
            ge = a % 10;
            shi = a / 10 % 10;
            sum = Math.pow(ge, 2) + Math.pow(shi, 2);
            boolean s = false;
                if (a == sum) {
                    s = true;
                }
            if(s){
                count++;
            }
        }
        System.out.println("二位数的自幂数数量为：" + count);
    }
}
