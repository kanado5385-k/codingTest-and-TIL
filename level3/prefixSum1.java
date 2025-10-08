package level3;

public class prefixSum1 {
    class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long total1 = 0;
        long total2 = 0;
        long min1 = 0;
        long min2 = 0;
        for (int i = 0; i < sequence.length; i++) {
            int num = sequence[i];
            int sign = (i % 2 == 0) ? 1 : - 1;
            long pls1 = num * sign;
            long pls2 = num * -sign;
            
            total1 = total1 + pls1;
            total2 = total2 + pls2;
            
            answer = Math.max(answer, Math.max(total1 - min1, total2 - min2));
            
            min1 = Math.min(min1, total1);
            min2 = Math.min(min2, total2);
        }
        return answer;
    }
}
}
