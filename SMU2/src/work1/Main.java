package work1;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String maxName = "";
        int maxScore = 0, maxChinese = 0, maxMath = 0, maxEnglish = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int chinese = sc.nextInt();
            int math = sc.nextInt();
            int english = sc.nextInt();
            int score = chinese + math + english;
            if(maxScore < score || i == 0){
                maxName = name;
                maxChinese = chinese;
                maxMath = math;
                maxEnglish= english;
                maxScore = score;
            }
        }
        System.out.printf("%s %d %d %d", maxName, maxChinese, maxMath, maxEnglish);
    }
}
