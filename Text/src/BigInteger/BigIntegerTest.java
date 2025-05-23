package BigInteger;

import java.math.BigInteger;
import java.util.function.BiFunction;

public class BigIntegerTest {
    public static void main(String[] args) {
        //创建BigInteger对象
        BigInteger bd1 = BigInteger.valueOf(2);
        BigInteger bd2 = BigInteger.valueOf(10);

        //加法
        BigInteger bd3 = bd1.add(bd2);
        BigInteger bd4 = bd3.add(bd1);
        System.out.println(bd3);
        System.out.println(bd4);

        //出发，获取商和余数
        BigInteger[] arr = bd2.divideAndRemainder(bd1);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        //比较是否相同
        boolean result = bd1.equals(bd2);
        System.out.println(result);

        //次幂
         BigInteger bd5 = bd1.pow(4);
        System.out.println(bd5);

        //返回较大值或者较小值
        System.out.println(bd1.max(bd2));

    }
}
