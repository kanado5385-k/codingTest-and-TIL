package level1;
import java.util.Arrays;

public class grredy1 {

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int sum = 0;
        
        int i = 0;
        while(i < d.length) {
            sum += d[i];
            answer++;
            if (sum == budget) {
                break;
            }
            if (sum > budget) {
                answer--;
                break;
            }
            i++;
        }

        return answer;
    }
}
}
