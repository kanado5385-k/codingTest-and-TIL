package level2;

public class program1 {
    class Solution {
    static int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);
        int answer = maxDungeons;
        return answer;
    }
    
    public void dfs(int k, int dungeon, int[][] dungeons, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == false && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs (k - dungeons[i][1], dungeon + 1, dungeons, visited);
                visited[i] = false;
            }
        }
        
        maxDungeons = Math.max(maxDungeons, dungeon);
    }
}
}
