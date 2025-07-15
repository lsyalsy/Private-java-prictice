package work04;

public class Student {
    private String name;
    private int age;
    private int id;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }

    public Student(){
        this("未知", 0);
        System.out.println("调用了无参构造方法");
    }
    public Student(String name, int age){
        this(name, age, 0);
        this.name = name;
        this.age = age;
        System.out.println("调用了双参构造方法");
    }
    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
        System.out.println("调用了三参构造方法");
    }
}
