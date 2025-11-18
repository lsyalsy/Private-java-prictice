package Calculate;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluator {
    private static final char[][] PRIORITY = {
            // +   -    *    /    (    )    #
            {'>', '>', '<', '<', '<', '>', '>'}, // +
            {'>', '>', '<', '<', '<', '>', '>'}, // -
            {'>', '>', '>', '>', '<', '>', '>'}, // *
            {'/', '>', '>', '>', '<', '>', '>'}, // /
            {'<', '<', '<', '<', '<', '=', ' '}, // (
            {'>', '>', '>', '>', ' ', '>', '>'}, // )
            {'<', '<', '<', '<', '<', ' ', '='}  // #
    };

    private static int getIndex(char op) {
        switch (op) {
            case '+': return 0;
            case '-': return 1;
            case '*': return 2;
            case '/': return 3;
            case '(': return 4;
            case ')': return 5;
            case '#': return 6;
            default: return -1;
        }
    }

    private static char comparePriority(char θ1, char θ2) {
        int i = getIndex(θ1);
        int j = getIndex(θ2);
        return PRIORITY[i][j];
    }

    private static double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return b + a;
            case '-': return b - a;
            case '*': return b * a;
            case '/':
                if (a == 0) System.out.println("除数不能为0");
                return b / a;
            default: System.out.println("非法运算符: " + op);
        }
        return -1;
    }

    public static double evaluate(String expr) {
        Stack<Double> opnd = new Stack<>();
        Stack<Character> optr = new Stack<>();
        optr.push('#');
        int i = 0;
        int len = expr.length();

        while (i < len || optr.peek() != '#') {
            char c = (i < len) ? expr.charAt(i) : '#';

            if (Character.isDigit(c)) {
                double num = 0;
                while (i < len && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                opnd.push(num);
            } else {
                char topOp = optr.peek();
                char pri = comparePriority(topOp, c);

                switch (pri) {
                    case '<':
                        optr.push(c);
                        i++;
                        break;
                    case '>':
                        char op = optr.pop();
                        double a = opnd.pop();
                        double b = opnd.pop();
                        opnd.push(calculate(a, b, op));
                        break;
                    case '=':
                        optr.pop();
                        i++;
                        break;
                    default:
                        System.out.println("表达式格式错误");
                }
            }
        }
        return opnd.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入算术表达式（如5+6*(1+2)-4）：");
        String expr = sc.nextLine();
        try {
            double result = evaluate(expr);
            System.out.println("表达式结果：" + result);
        } catch (Exception e) {
            System.out.println("计算失败");
        }
        sc.close();
    }
}
