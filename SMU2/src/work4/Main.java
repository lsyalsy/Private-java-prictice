package work4;
import java.util.*;
public class Main{
    static List<int[]> solutions = new ArrayList<>();
    static int[] ingredient = new int[10];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        find(0, 0);
        System.out.println(solutions.size());
        for(int[] solution : solutions){
            for (int i = 0; i < 10; i++) {
                System.out.print(solution[i] + " ");
            }
            System.out.println();
        }
    }

    static void find(int index, int currentSum){
        if(index == 10){
            if(currentSum == n){
                solutions.add(ingredient.clone());
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(currentSum + i > n) break;
            ingredient[index] = i;
            find(index + 1, currentSum + i);
        }
    }
}