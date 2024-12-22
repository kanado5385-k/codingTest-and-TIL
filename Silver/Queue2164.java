import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();
        
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (true) {

            if (queue.size() == 1){
                break;
            }
            queue.poll();

            if (queue.size() == 1){
                break;
            }
            int curNum = queue.poll();
            queue.offer(curNum);
        }

        System.out.println(queue.poll());
        sc.close();
    }
}
