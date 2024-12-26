import java.util.Scanner;
import java.util.Stack;

public class Stack4949 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            Stack<Character> stack= new Stack<>();
            String string = sc.nextLine();
            boolean isBalanced = true;
            if (string.equals(".")){
                break;
            }
            for (char word : string.toCharArray()) {
                if (word == '(' || word == '[') {
                    stack.push(word);
                }
                else if(word == ')') {
                    if (stack.empty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                }
                else if(word == ']') {
                    if (stack.empty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
                else{
                    continue;
                }
            }
            if (!stack.empty()) {
                isBalanced = false;
            }

            if (isBalanced) {
                sb.append("yes\n");
            }
            else {
                sb.append("no\n");
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
