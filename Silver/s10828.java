import java.io.*;
import java.util.*;

public class s10828 {
public static void main (String[] args) throws IOException{
    BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int T = Integer.parseInt(b.readLine());

    for (int t = 0; t < T; t++) {
        String command = b.readLine();

        if (command.startsWith("push")) {
            int num = Integer.parseInt(command.split(" ")[1]);
            stack.push(num);
        } else if (command.contains("pop")) {
            if (stack.empty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(stack.pop()).append("\n");
            }
        } else if (command.contains("empty")) {
            if (stack.empty()) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        } else if (command.contains("size")) {
            sb.append(stack.size()).append("\n");
        } else if (command.contains("top")) {
            if (stack.empty()) {
                sb.append(-1).append("\n");
            } else {
                sb.append(stack.peek()).append("\n");
            }
        }
    }

    System.out.println(sb.toString());

}
}
