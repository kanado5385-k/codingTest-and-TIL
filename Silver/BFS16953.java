import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS16953 {
    static long result = -1;
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int start = sc.nextInt();
    int target = sc.nextInt();

    Queue<long[]> queue = new LinkedList<>();
    queue.offer(new long[]{start, 1});

    while (!queue.isEmpty()) {
        long[] current = queue.poll();
        long currentNumber = current[0];
        long currentDistance = current[1];

        if (currentNumber == target) {
            result = currentDistance;
            break;
        }
        else if (currentNumber > target) {
            continue;
        }

        long doubleNum = currentNumber * 2;
        if (doubleNum <= target) {
            queue.offer(new long[]{doubleNum, currentDistance + 1});
        }

        String string = String.valueOf(currentNumber) + 1;
        long onePlusNum = Long.parseLong(string);
        if (onePlusNum <= target) {
            queue.offer(new long[]{onePlusNum, currentDistance + 1});
        }
        
    
        
    }

    System.out.println(result);
    sc.close();
    }
}
