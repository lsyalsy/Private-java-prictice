package Test;

public class test01 {
    public static void main(String[] args) {
        String A = "abcde";
        String B = "bcdea";
        boolean T = check(A, B);
        System.out.println(T);
    }
    //创建一个方法，需要字符串，转化，返回字符串
    public static String  move(String A){
        char a = A.charAt(0);
       String end =  A.substring(1);
       return end + a;
    }
    public static boolean check(String A, String B){
        for (int i = 0; i < A.length(); i++) {
            A = move(A);
            if (A.equals(B)){
                return true;
            }
        }
        return false;
    }
}
