package level2;
import java.util.*;

public class dfs5 {
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int[][] newMap;
    List<Integer> answer = new ArrayList<>();
    
    boolean[][] visited;
    public int[] solution(String[] maps) {
        newMap = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            String curIsland = maps[i];
            for (int j = 0; j < maps[0].length(); j++) {
                char curLocal = curIsland.charAt(j);
                if (curLocal == 'X') {
                   newMap[i][j] = 0; 
                } else {
                    newMap[i][j] = Integer.parseInt(String.valueOf(curLocal));
                }
            }
        }
        
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[0].length; j++) {
                if (newMap[i][j] != 0 && visited[i][j] == false) {
                    int sum = dfs(i, j, newMap[i][j]);
                    answer.add(sum);
                }
            }
        }
        
        if (answer.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
    
    public int dfs(int x, int y, int sum) {
        visited[x][y] = true;
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx >= 0 && ny >= 0 && nx < newMap.length && ny < newMap[0].length) {
                if (newMap[nx][ny] != 0 && visited[nx][ny] == false) {
                    sum = sum + newMap[nx][ny];
                    sum = dfs(nx, ny, sum);
                }
            }
        }
        
        return sum;
    }
}
}
