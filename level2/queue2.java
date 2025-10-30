package level2;
import java.util.*;

public class queue2 {
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        
        int outCount = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            boolean isBiggest = true;
            
            for (int[] next: q) {
                if (next[1] > cur[1]) {
                    q.add(new int[]{cur[0], cur[1]});
                    isBiggest = false;
                    break;
                }
            }
            
            if (isBiggest) {
                outCount++;
                if (location == cur[0]) {
                   answer =  outCount;
                    break;
                }
            }
        }
        
        return answer;
    }
}
}
