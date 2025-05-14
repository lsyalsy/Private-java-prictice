package W1_OneToN;

public class Sum implements OneToN{

    @Override
    public double calculate(int n) {
        double Sum = 0;
        for (int i = 0; i <= n; i++) {
            Sum += i;
        }
        return Sum;
    }
}
