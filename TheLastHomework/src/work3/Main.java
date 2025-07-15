package work3;

public class Main {
    public static void main(String[] args){
        Account a = new Account("202430809352", "张三", "男", 18, 283441.48);
        System.out.println("账户：" + a.getAccount());
        System.out.println("姓名：" + a.getName());
        System.out.println("性别：" + a.getGender());
        System.out.println("年龄：" + a.getAge());
        System.out.println("余额：" + a.getBalance());
    }
}
