import java.util.Scanner;
import java.util.Stack;

public class Stack1874 {
    public static void main (String[] args) {
        int[] arr;
        int natureNum = 0;
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isGood = true;

        for (int i = 0; i < N; i++) {
            int curNum = arr[i];

            while (natureNum < curNum) {
                stack.push(++natureNum);
                sb.append("+\n");
            }

            if (stack.peek() == curNum) {
                stack.pop();
                sb.append("-\n");
            } else {
                isGood = false;
                break;
            }
        }
        if (isGood) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
    
}
