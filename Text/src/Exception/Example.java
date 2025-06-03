package Exception;

import java.util.Random;

public class Example {
    public double result(int x, int y){
        double A = 4.0 * x - 4.0;
        double B = 2.0 * x * x - 4.0 * x * y + y * y;
        double C = A / B;
        try{
            if(A == 0 || B == 0){
                throw new ArithmeticException("A或B=0");
            }
            throw new Exception("program is ok!");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("program is end");
        }

        C = A / B;
        return C;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt(20);
        int y = r.nextInt(20);
        Example example = new Example();
        double result = example.result(x, y);
        System.out.printf("x=%d, y=%d, 结果：%.2f%n", x, y, result);

    }
}
