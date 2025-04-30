package ClassTest01;

public class Teacher extends Person {
    private String course;
    private int studentNum;

    // 全属性构造方法
    public Teacher(String name, int age, String nationality, String course, int studentNum) {
        super(name, age, nationality);
        this.course = course;
        this.studentNum = studentNum;
    }

    // 指定姓名、年龄、课程、学生人数，国籍未知
    public Teacher(String name, int age, String course, int studentNum) {
        super(name, age);
        this.course = course;
        this.studentNum = studentNum;
    }

    // 指定姓名、年龄、国籍、课程，学生人数默认40
    public Teacher(String name, int age, String nationality, String course) {
        super(name, age, nationality);
        this.course = course;
        this.studentNum = 40;
    }

    // 指定姓名、国籍，课程默认“计算机文化基础”，年龄20，学生人数40
    public Teacher(String name, String nationality) {
        super(name, nationality);
        this.course = "计算机文化基础";
        this.studentNum = 40;
    }

    // 仅指定姓名，年龄20，国籍未知，课程默认“计算机文化基础”，学生人数40
    public Teacher(String name) {
        super(name);
        this.course = "计算机文化基础";
        this.studentNum = 40;
    }

    // Getter和Setter方法
    public String getCourse() { return course; }
    public int getStudentNum() { return studentNum; }

    public void setCourse(String course) { this.course = course; }
    public void setStudentNum(int studentNum) { this.studentNum = studentNum; }

    // 重写introduce方法
    @Override
    public void introduce() {
        super.introduce();
        if (getAge() <= 28) {
            System.out.printf("我是一名青年教师，这学期讲授%s课程，共有%d名学生。%n", course, studentNum);
        } else {
            System.out.printf("我是一名教师，这学期讲授%s课程，共有%d名学生。%n", course, studentNum);
        }
    }
}
