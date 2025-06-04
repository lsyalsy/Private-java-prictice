package Exception;

import java.util.Random;

public class Example {
    public double result(double x, double y){
        double A = 4 * x - 4;
        double B = 2 * x * x - 4 * x * y + y * y;
        double C = A / B;
        try{
            if(A == 0||B == 0){
                throw new ArithmeticException("A 或 B =0");
            }
            throw new Exception("program is ok!");
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("program is end");
        }
        return C;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt(20);
        int y = r.nextInt(20);
        Example example = new Example();
        System.out.println(example.result(x, y));
    }
}
