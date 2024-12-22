import java.util.Scanner;
import java.util.Stack;

public class Stack17952 {
    public static void main (String[] args) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int assig = sc.nextInt();

            if (assig == 0) {
                if(!stack.isEmpty()) {
                    int[] curScore = stack.pop();
                    curScore[1]--;

                    if (curScore[1] != 0) {
                        stack.push(curScore);
                    }
                    else {
                        result += curScore[0];
                    }
                }
            }
            else {
                int score = sc.nextInt();
                int min = sc.nextInt();

                stack.add(new int[]{score, min - 1});
                int[] curScorePeek = stack.peek();
                if (curScorePeek[1] == 0){
                    stack.pop();
                    result += curScorePeek[0];
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
