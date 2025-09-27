package level2;

public class greedy4 {
    class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) != 'A') {
                int count = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
                answer += count;
            }
        }
        
        int distans = len - 1;
        for(int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            distans = Math.min(distans, i * 2 + len - next);
            distans = Math.min(distans, (len - next) * 2 + i);
        }
        
        answer += distans;
        return answer;
    }
}
}
