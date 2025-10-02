package level3;

public class dp2 {
    class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 1;
        long[][] dp = new long[n + 1][m + 1];
        
        for (int[] water : puddles) {
            dp[water[1]][water[0]] = -1;
        }
        
        
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue; 
                }
                if (j - 1 != 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }
                if (i - 1 != 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
            }
        }
        
        answer = (int)(dp[n][m] % 1000000007);
        
        return answer;
    }
}
}
