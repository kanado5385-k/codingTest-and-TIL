package level3;

public class dp4 {
    class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int targetAlp = Integer.MIN_VALUE;
        int targetCop = Integer.MIN_VALUE;
        int[][] dp;
        
        for (int i = 0; i < problems.length; i++) {
            int curAlp = problems[i][0];
            int curCop = problems[i][1];
            targetAlp = Math.max(targetAlp, curAlp); // 10
            targetCop = Math.max(targetCop, curCop); // 11
        }
        
        dp = new int [targetAlp + 2][targetCop + 2];
        
        for (int i = 0; i <= targetAlp; i++) {
            for (int j = 0; j <= targetCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        

        
        dp[alp][cop] = 0;
        
        for (int i = alp; i < targetAlp + 1; i++) {
            for (int j = cop; j < targetCop + 1; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for (int[] curProblem : problems) {
                    int reqAlp = curProblem[0];
                    int reqCop = curProblem[1];
                    int rwdAlp = curProblem[2];
                    int rwdCop = curProblem[3];
                    int cost = curProblem[4];
                    
                    if (i >= reqAlp && j >= reqCop) {
                        int nextAlp = Math.min(targetAlp, i + rwdAlp);
                        int nextCop = Math.min(targetCop, j + rwdCop);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        answer = dp[targetAlp][targetCop];
        
        return answer;
    }
}
}
