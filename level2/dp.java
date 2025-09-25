package level2;

public class dp {
    class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                max = Integer.MIN_VALUE;
                
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue;
                    max = Math.max(max, land[i - 1][k]);
                }
                
                land[i][j] += max;
            }
        }
        
        max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, land[len - 1][i]);
        }
        
        int answer = max;

        return answer;
    }
}
}
