package level2;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int index = cur[0];
            int sum = cur[1];
            
            if (index == numbers.length) {
                if (sum == target) {
                    answer++;
                }
            }
            else {
                queue.add(new int[]{index + 1, sum + numbers[index]});
                queue.add(new int[]{index + 1, sum - numbers[index]});
            }
        }
        
        
        
        return answer;
    }
}
}
