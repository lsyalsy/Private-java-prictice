package work01;

public class StudentTest {
    public static void main(String args[]){
        Student s1 = new Student("张三", 21, '男', "01");
        Student s2 = new Student('男', 22);
        s2.setName("李四");
        s2.setId("02");
        System.out.println("姓名：" + s1.getName() + "年龄：" + s1.getAge() + "性别：" + s1.getGender() + "学号：" + s1.getId());
        System.out.println("姓名：" + s2.getName() + "年龄：" + s2.getAge() + "性别：" + s2.getGender() + "学号：" + s2.getId());
    }
}
