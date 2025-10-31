package level2;
import java.util.*;
    
public class greedy6 {
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            }
            int curLeft = people[left];
            int curRight = people[right];
            
            if (curLeft + curRight <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            
            answer++;
        }
        
        return answer;
    }
}
}
