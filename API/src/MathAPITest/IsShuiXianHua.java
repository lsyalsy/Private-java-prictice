package MathAPITest;

public class IsShuiXianHua {
    public static void main(String[] args) {
        //要求：统计水仙花数的数量
        int count = 0;
        double sum;
        for (int i = 100; i < 999; i++) {
            double ge = i % 10;
            double shi = i / 10 % 10;
            double bai = i /100 % 10;
            sum = Math.pow(ge, 3.0) + Math.pow(shi, 3.0) + Math.pow(bai, 3.0);
            if( sum == i){
                count++;

            }
        }
        System.out.println("水仙花数的数量是" + count);
    }
}
