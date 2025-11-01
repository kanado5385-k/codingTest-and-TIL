package level2;

public class dfs6 {
class Solution {
    int maxDungeon = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);
        
        answer = maxDungeon;
        return answer;
    }
    
    public void dfs(int k, int dungeonSum, int[][] dungeons, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && visited[i] == false) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeonSum + 1, dungeons, visited);
                visited[i] = false;
            }
        }
        
        maxDungeon = Math.max(maxDungeon, dungeonSum);
    }
}
}
