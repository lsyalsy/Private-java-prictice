package work5;
import java.io.*;
import java.util.Scanner;

public class Main{
    static int n;
    static int[] permutation;
    static boolean[] used;
    static PrintWriter pr = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        used = new boolean[n + 1];
        permutation = new int[n];
        backtrack(0);
        pr.flush();
    }

    static void backtrack(int index){
        if(index == n){
            for(int num : permutation){
                pr.printf("%5d", num);
            }
            pr.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!used[i]){
                used[i] = true;
                permutation[index] = i;
                backtrack(index + 1);
                used[i] = false;

            }
        }
    }
}
