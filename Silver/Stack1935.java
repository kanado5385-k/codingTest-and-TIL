import java.util.Scanner;
import java.util.Stack;

public class Stack1935 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values;

        int N = sc.nextInt();
        sc.nextLine();
        String formula = sc.nextLine();

        values = new double[N];
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            char curValue = formula.charAt(i);

            if (Character.isLetter(curValue)) {
                stack.push(values[curValue - 'A']);
            }else {
                double a = stack.pop();
                double b = stack.pop();
                double value = 0;
                switch (curValue) {
                    case '+':
                        value = b + a;
                        break;
                    case '-':
                        value = b - a;
                        break;
                    case '*':
                        value = b * a;
                        break;        
                
                    case '/':
                        value = b / a;
                        break;
                }
                stack.push(value);
            }
        }

        System.out.printf("%.2f\n",stack.pop());
        sc.close();
    }
}
