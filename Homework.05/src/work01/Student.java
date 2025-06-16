package work01;

public class Student {
    private String name;
    private int age;
    private char gender;
    private String id;

    public Student(char gender, int age){
        this.gender = gender;
        this.age = age;
    }

    public Student(String name, int age, char gender, String id){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public char getGender(){
        return gender;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
}
