package Complex;

public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        StringBuilder z1 = new StringBuilder(c1.Create(2, 6));
        StringBuilder z2 = new StringBuilder(c2.Create(8, 3));
        System.out.println("创建了两个复数：" + z1 + " 和 " + z2);
        Complex c3 = new Complex();
        System.out.println("复数求和：" + c3.Add(z1, z2));
        System.out.println("复数求差：" + c3.Subtract(z1, z2));
        System.out.println("复数求积" + c3.Multiply(z1, z2));
        System.out.println("第一个复数的实部：" + c3.Get_RealPart(z1));
        System.out.println("第一个复数的虚部：" + c3.Get_ImaginaryPart(z1));




    }
}
