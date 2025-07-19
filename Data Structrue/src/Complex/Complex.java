package Complex;

public class Complex {
    private int x;
    private int y;
//生成一个复数
    public StringBuilder Create(int x, int y){
        this.x = x;
        this.y = y;
        StringBuilder z = new StringBuilder();
        z.append(x).append(" + ").append(y).append("i");
        return z;
    }

//复数求和
    public StringBuilder Add(StringBuilder z1, StringBuilder z2){
        int x1 = Integer.parseInt(z1.substring(0, z1.indexOf(" + ")));
        int y1 = Integer.parseInt(z1.substring(z1.indexOf(" + ") + 3, z1.indexOf("i")));
        int x2 = Integer.parseInt(z2.substring(0, z2.indexOf(" + ")));
        int y2 = Integer.parseInt(z2.substring(z2.indexOf(" + ") + 3, z2.indexOf("i")));
        int x3 = x1 + x2;
        int y3 = y1 + y2;
        StringBuilder z3 = new StringBuilder();
        z3.append(x3).append(" + ").append(y3).append("i");
        return z3;
    }

//复数求差
    public StringBuilder Subtract(StringBuilder z1, StringBuilder z2){
        int x1 = Integer.parseInt(z1.substring(0, z1.indexOf(" + ")));
        int y1 = Integer.parseInt(z1.substring(z1.indexOf(" + ") + 3, z1.indexOf("i")));
        int x2 = Integer.parseInt(z2.substring(0, z2.indexOf(" + ")));
        int y2 = Integer.parseInt(z2.substring(z2.indexOf(" + ") + 3, z2.indexOf("i")));
        int x3 = x1 - x2;
        int y3 = y1 - y2;
        StringBuilder z3 = new StringBuilder();
        z3.append(x3).append(" + ").append(y3).append("i");
        return z3;
    }

//复数求积
    public StringBuilder Multiply(StringBuilder z1, StringBuilder z2){
        int x1 = Integer.parseInt(z1.substring(0, z1.indexOf(" + ")));
        int y1 = Integer.parseInt(z1.substring(z1.indexOf(" + ") + 3, z1.indexOf("i")));
        int x2 = Integer.parseInt(z2.substring(0, z2.indexOf(" + ")));
        int y2 = Integer.parseInt(z2.substring(z2.indexOf(" + ") + 3, z2.indexOf("i")));
        int x3 = x1 * x2 - y1 * y2;
        int y3 = x1 * y2 + y1 * x2;
        StringBuilder z3 = new StringBuilder();
        z3.append(x3).append(" + ").append(y3).append("i");
        return z3;
    }

//取复数的实部
    public int Get_RealPart(StringBuilder z){
        return Integer.parseInt(z.substring(0, z.indexOf(" + ")));
    }

//取复数的虚部
    public int Get_ImaginaryPart(StringBuilder z){
        return Integer.parseInt(z.substring(z.indexOf(" + ") + 3, z.indexOf("i")));
    }
}
