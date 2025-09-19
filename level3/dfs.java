package level3;

public class dfs {
    class Solution {
    static boolean[] visited;
    static int minStep = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isPosible = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                isPosible = true;
            }
        }
        
        if (isPosible) {
            visited = new boolean[words.length];
            dfs(0, begin, target, words);
            answer = minStep;
        }

        return answer;
    }
    
    public void dfs(int step, String curWord, String target, String[] words) {
        
        if (curWord.equals(target)) {
            if (step < minStep) {
                minStep = step;
            }
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            int changePossibility = 0;
            if (visited[i] == false) {
                for (int j = 0; j < target.length(); j++) {
                    char curWordChar = curWord.charAt(j);
                    char nextWordChar = words[i].charAt(j);
                    if (curWordChar != nextWordChar) {
                        changePossibility++;
                    }
                }
                
                if (changePossibility == 1) {
                    visited[i] = true;
                    dfs(step + 1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }
    }
}
}
