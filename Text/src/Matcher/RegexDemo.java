package Matcher;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String s = "Java自从95年问世以来，已经经历了很多版本，目前企业中使用最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，" +
                "相信在不久的将来Java17也会逐渐登上历史的舞台";
        String regex = "((?i)Java)(?=8|11|17)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while(m.find()){
            System.out.println(m.group());
        }


    }
}
