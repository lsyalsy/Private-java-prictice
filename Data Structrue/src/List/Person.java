package List;

public class Person {
    private int ID;
    private int age;
    private int income;
    private String edu_level;

    public Person(int ID, int age, int income, String edu_level) {
        this.ID = ID;
        this.age = age;
        this.income = income;
        this.edu_level = edu_level;
    }
    public int getID() {
        return ID;
    }
    public int getAge() {
        return age;
    }
    public int getIncome() {
        return income;
    }
    public String getEdu_level() {
        return edu_level;
    }
    @Override
    public String toString() {
        return "Person [ID=" + ID + ", age=" + age + ", income=" + income + ", edu_level=" + edu_level + "]";
    }
}
