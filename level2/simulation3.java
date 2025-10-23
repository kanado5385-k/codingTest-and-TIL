package level2;
import java.util.*;

public class simulation3 {

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int curNum = 0;
        Queue<Character> qu = new LinkedList<>();
        
        int curT = 0;
        int curM = 1;
        while (curT < t) {
            if (qu.isEmpty()) {
                String convert = Integer.toString(curNum, n);
                convert = convert.toUpperCase();
                for (char ch : convert.toCharArray()) {
                    qu.offer(ch);
                }
                curNum++;
            }
            
            if (curM == p) {
                answer.append(qu.poll());
                curT++;
            } else {
                qu.poll();
            }
            
            if (curM + 1 == m + 1) {
                curM = 1;
            } else {
                curM++;
            }
        }
        
        return answer.toString();
    }
}
}
