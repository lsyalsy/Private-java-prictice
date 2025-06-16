package Work03;
import java.util.Random;

public class Main {
    public static void main(String args[]){
        //随机生成10个随机成绩
        Random r = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = r.nextInt(101);
        }
        //展示随机生成的原数组
        System.out.println("随机生成的原数组为：");
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
        //冒泡排序递减
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] <= arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为：");
        for(int n : arr){
            System.out.print(n + " ");
        }
    }
}
