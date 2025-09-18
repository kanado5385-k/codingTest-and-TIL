package level2;
import java.util.Queue;
import java.util.LinkedList;

public class bfs2 {

class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length();
        int[][] newMap = new int[n][m];

        int startX = 0;
        int startY = 0;
        boolean[][][] visited = new boolean[n][m][2];
            
        for (int i = 0; i < n; i++) {
            String level = maps[i];
            for (int j = 0; j < m; j++) {
                char ch = level.charAt(j);
                switch(ch) {
                    case 'S': 
                        newMap[i][j] = 1;
                        startX = i;
                        startY = j;
                        break;
                    case 'E': 
                        newMap[i][j] = 2;
                        break;
                    case 'L': 
                        newMap[i][j] = 3;
                        break;
                    case 'O': 
                        newMap[i][j] = 1;
                        break;
                    case 'X': 
                        newMap[i][j] = 0;
                        break;
                }
                
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0, 0 }); //x,y,second, levelState
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int second = cur[2];
            int levelState = cur[3];
            
            if (newMap[x][y] == 2) {
                if (levelState == 1) {
                    answer = second;
                    break;
                }
            }
            
            if (newMap[x][y] == 3) {
                levelState = 1;
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && newMap[nx][ny] != 0) {
                    if (visited[nx][ny][levelState] == false) {
                        visited[nx][ny][levelState] = true;
                        queue.add(new int[]{nx, ny, second + 1, levelState});
                    }
                }
            }

        }
        
        return answer;
    }
}
}
