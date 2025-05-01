package ClassTest02;

public class CylinderDemo {
    public static void main(String[] args) {
        // 创建半径3.2的圆对象并输出
        Circle c = new Circle(3.2);
        c.output();

        // 创建底面半径2.3、高4的圆柱对象并输出
        Cylinder cy = new Cylinder(2.3, 4);
        cy.output();

        // 修改圆柱的半径为1.5、高为3并输出
        cy.setRadius(1.5);
        cy.setHeight(3);
        cy.output();
    }
}