package W1_OneToN;

public class Pro implements OneToN{
    @Override
    public double calculate(int n){
        double Pro = 1;
        for (int i = 1; i <= n; i++) {
            Pro *= i;
        }
        return Pro;
    }
}
