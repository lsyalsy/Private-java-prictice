package ClassTest02;

public class Circle {
    private double radius; // 私有半径属性

    // 指定半径的构造方法
    public Circle(double radius) {
        this.radius = radius;
    }

    // 无参构造方法，半径默认1.0
    public Circle() {
        this(1.0);
    }

    // 半径的getter方法
    public double getRadius() {
        return radius;
    }

    // 半径的setter方法
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 计算圆面积
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 计算圆周长
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // 输出圆的描述信息
    public void output() {
        System.out.printf("半径为%.1f的圆的面积是%.2f, 周长是%.2f%n",
                radius, getArea(), getCircumference());
    }
}