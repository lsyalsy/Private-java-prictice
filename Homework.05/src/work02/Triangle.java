package work02;

public class Triangle {
    private double a;
    private double b;
    private double c;
    private double area;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea(){
        return area;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }

    public void computeArea(double a, double b, double c){
        double p = (a + b + c) / 2;
        this.area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
