package level2;

public class bruteForce2 {
    class Solution {
    static boolean isFinish = false;
    static int number = -1;
    static int count = 0;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        dfs("", word);
        return number;
    }
    
    public void dfs(String current, String target) {
        if (current.equals(target)) {
            number = count;
            isFinish = true;
            return;
        }
        
        if (current.length() == 5 || isFinish) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            count++;
            dfs(current + alphabet[i], target);
        }
    }
}
}
