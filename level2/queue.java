package level2;
import java.util.Queue;
import java.util.LinkedList;

public class queue {
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> newQueue1 = new LinkedList<>();
        Queue<Integer> newQueue2 = new LinkedList<>();
        long answer = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        
        for (int i = 0; i < queue1.length; i++) {        
            newQueue1.offer(queue1[i]);
            queue1Sum += queue1[i];
            
            newQueue2.offer(queue2[i]);
            queue2Sum += queue2[i];
        }
        
        while (true) {
            if (answer > queue1.length * 3) {
                answer = -1;
                break;
            }
            
            if (queue1Sum > queue2Sum) {
                int curNum = newQueue1.poll();
                queue1Sum -= curNum;
                newQueue2.offer(curNum);
                queue2Sum += curNum;
                answer++;
            } else if (queue2Sum > queue1Sum) {
                int curNum = newQueue2.poll();
                queue2Sum -= curNum;
                newQueue1.offer(curNum);
                queue1Sum += curNum;
                answer++;
            } else if (queue2Sum == queue1Sum) {
                break;
            }
        }
        return (int) answer;
    }
}
}
