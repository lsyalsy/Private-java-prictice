package work3;

public class Account {
    private String account;
    private String name;
    private String gender;
    private int age;
    private double balance;

    public Account(){
    }
    public Account(String account, String name, String gender, int age, double balance){
        this.account = account;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.balance = balance;
    }

    public String getAccount(){
        return account;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public double getBalance(){
        return balance;
    }
}
