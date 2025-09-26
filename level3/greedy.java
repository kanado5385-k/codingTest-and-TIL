package level3;

import java.util.Arrays;

public class greedy {
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        
        int camera = Integer.MIN_VALUE;
        for (int[] car: routes) {
            int start = car[0];
            int end = car[1];
            
            if (camera < start) {
                camera = end;
                answer++;
            }
        }

        return answer;
    }
}
}
