import java.util.Scanner;
import java.util.Stack;

public class s1874 {
    public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int n = s.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
        arr[i] = s.nextInt();
    }

    int pointer = 0;

    for (int i = 1; i <= n; i++) {
        stack.push(i);
        sb.append("+").append("\n");

        while (stack.peek() == arr[pointer]) {
            stack.pop();
            sb.append("-").append("\n");
            pointer++;
            if (stack.empty()) {
                break;
            }
        }
    }

    if (!stack.empty()) {
        sb = new StringBuilder();
        sb.append("NO");
    }

    System.out.println(sb.toString());
    s.close();
    
    }
}

// 시간복잡도 = O(n)
