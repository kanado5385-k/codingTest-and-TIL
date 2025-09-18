package level2;
import java.util.Queue;
import java.util.LinkedList;

public class bfs1 {

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n+1][m+1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int stepSum = cur[2];
            
            if (curX == n - 1 && curY == m - 1) {
                answer = stepSum;
                break;
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(visited[nx][ny] == false && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, stepSum + 1});
                    }
                }
            }
        }
        
        return answer;
    }
}
}
