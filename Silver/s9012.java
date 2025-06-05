import java.util.Scanner;
import java.util.Stack;

public class s9012 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < T; t++) {
            stack = new Stack<>();
            String str = sc.nextLine();
            if (isVPS(stack, str)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isVPS(Stack<Character> stack, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ps = str.charAt(i);
            if (ps == '(') {
                stack.push(ps);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
