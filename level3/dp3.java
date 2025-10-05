package level3;

public class dp3 {
    class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp = new int[money.length];
        
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        int[] dp2 = new int[money.length];
        
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        
        int answer = Math.max(dp[n - 2], dp2[n - 1]);
        return answer;
    }
}
}
