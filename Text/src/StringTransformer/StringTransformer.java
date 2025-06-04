package StringTransformer;

import java.util.Scanner;

public class StringTransformer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String input = sc.nextLine();
        StringBuilder output = new StringBuilder();
        for(Character c : input.toCharArray()){
            if (Character.isLowerCase(c)){
                output.append(Character.toUpperCase(c));
            }else if (Character.isUpperCase(c)){
                output.append(Character.toLowerCase(c));
            }else if (Character.isDigit(c)){
                output.append(0);
            }else{
                output.append("#");
            }
        }
        System.out.println(output.toString());
        sc.close();
    }
}
