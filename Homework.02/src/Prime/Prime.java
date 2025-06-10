package Prime;

import java.util.ArrayList;

public class Prime {
    //判断100以内的素数
    public static void main(String[] args) {
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if(isPrime(i)){
                primeList.add(i);
            }
        }
        System.out.println("素数的数量为：" + primeList.size());
        System.out.println("分别为：");
        for(int n : primeList){
            System.out.print( n + " ");
        }

    }
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
