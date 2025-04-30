package ClassTest01;

public class PersonDemo {
    public static void main(String[] args) {
        // 创建张榕对象
        Person zhangRong = new Person("张榕", "中国");
        zhangRong.introduce();

        // 创建李婷婷教师对象
        Teacher liTingting = new Teacher("李婷婷", "中国");
        liTingting.introduce();

        // 修改年龄为45岁
        liTingting.setAge(45);
        liTingting.introduce();

        // 修改授课名称和学生人数
        liTingting.setCourse("面向对象程序设计");
        liTingting.setStudentNum(104);
        liTingting.introduce();
    }
}
