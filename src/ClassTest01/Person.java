package ClassTest01;

    public class Person {
        private String name;
        private int age;
        private String nationality;

        // 全属性构造方法
        public Person(String name, int age, String nationality) {
            this.name = name;
            this.age = age;
            this.nationality = nationality;
        }

        // 仅指定姓名，年龄默认20，国籍未知
        public Person(String name) {
            this(name, 20, "未知");
        }

        // 仅指定姓名和年龄，国籍未知
        public Person(String name, int age) {
            this(name, age, "未知");
        }

        // 仅指定姓名和国籍，年龄默认20
        public Person(String name, String nationality) {
            this(name, 20, nationality);
        }

        // Getter和Setter方法
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getNationality() { return nationality; }

        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public void setNationality(String nationality) { this.nationality = nationality; }

        // introduce方法
        public void introduce() {
            if ("未知".equals(nationality)) {
                System.out.printf("我叫%s，今年%d岁。%n", name, age);
            } else {
                System.out.printf("我叫%s，今年%d岁，我是%s人。%n", name, age, nationality);
            }
        }
    }

