package test;
import java.util.*;
public class Rock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String s1 = parts[0];
            String s2 = parts[1];

            if(s1.equals("Rock") && s2.equals("Scissors")){
                System.out.println("Player1");
            }else if(s1.equals("Scissors") && s2.equals("Paper")){
                System.out.println("Player1");
            }else if(s1.equals("Paper") && s2.equals("Rock")){
                System.out.println("Player1");
            }else if(s1.equals(s2)){
                System.out.println("Tie");
            }else{
                System.out.println("Player2");
            }
        }
    }
}
