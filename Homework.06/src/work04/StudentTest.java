package work04;

public class StudentTest {
    public static void main(String[] args){
        Student s1 = new Student();
        Student s2 = new Student("张三", 18);
        Student s3 = new Student("张三", 18, 20243080);
        System.out.println(s1.getName() + " " + s1.getAge() + " " + s1.getId());
        System.out.println(s2.getName() + " " + s2.getAge() + " " + s2.getId());
        System.out.println(s3.getName() + " " + s3.getAge() + " " + s3.getId());
    }
}
