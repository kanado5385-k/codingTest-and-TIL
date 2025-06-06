import java.util.Scanner;
import java.util.Stack;

public class s10799 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); 
        Stack<Character> stack = new Stack<>();

        String str = sc.nextLine();
        int result = 0;

        int arr[] = new int[100000];
        int pointer = 0;

        for (int i = 0; i < str.length(); i++) {
            if(stack.empty()) {
                stack.push(str.charAt(i));
                continue;
            }

            char now = str.charAt(i);
            if (now == '(') {
                if (stack.peek() == '(') {
                    pointer++;
                    arr[pointer] = 1;
                    stack.push(now);
                }
                else {
                    stack.push(now);
                }
            } else {
                if (stack.peek() == '(') {
                    for (int k = 1; k <= pointer; k++) {
                        int num = arr[k];
                        arr[k] = num + 1;
                    }
                    stack.push(now);
                }
                else {
                    result = result + arr[pointer];
                    arr[pointer] = 0;
                    pointer--;
                    stack.push(now);
                }
            }
        }

        System.out.println(result);
        sc.close();

    }
}

// O(N^2)
