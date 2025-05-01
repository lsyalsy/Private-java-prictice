package ClassTest02;

public class Cylinder extends Circle {
    private double height; // 私有高度属性

    // 指定半径和高的构造方法
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    // 仅指定半径，高默认1.0
    public Cylinder(double radius) {
        this(radius, 1.0);
    }

    // 无参构造方法，半径和高均默认1.0
    public Cylinder() {
        this(1.0, 1.0);
    }

    // 高度的getter方法
    public double getHeight() {
        return height;
    }

    // 高度的setter方法
    public void setHeight(double height) {
        this.height = height;
    }

    // 计算圆柱体积
    public double getVolume() {
        return getArea() * height;
    }

    // 计算圆柱表面积
    public double getSurfaceArea() {
        return 2 * getArea() + getCircumference() * height;
    }

    // 输出圆柱的描述信息
    public void output() {
        System.out.printf("底面半径为%.1f, 高为%.1f的圆柱的体积是%.2f, 表面积是%.2f%n",
                getRadius(), height, getVolume(), getSurfaceArea());
    }
}
