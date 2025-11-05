package level2;
import java.util.*;

public class simulation6 {
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        List<Integer> answer = new ArrayList<>();
        
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        for (int[] query : queries) {
            int startRow = query[0] - 1;
            int startColumn = query[1] - 1;
            int endRow = query[2] - 1;
            int endColumn = query[3] - 1;
            
            int keep = map[startRow][startColumn]; 
            int min = keep;
            int keep2 = 0;
            
            for (int i = startColumn; i < endColumn - 1; i++) {
                keep2 = map[startRow][i + 1];
                map[startRow][i + 1] = keep;
                keep = keep2;
                min = Math.min(min, keep);
            }
            
            for (int i = startRow; i < endRow; i++) {
                keep2 = map[i][endColumn];
                map[i][endColumn] = keep;
                keep = keep2;
                min = Math.min(min, keep);
            }
            
            for (int i = endColumn; i > startColumn; i--) {
                keep2 = map[endRow][i];
                map[endRow][i] = keep;
                keep = keep2;
                min = Math.min(min, keep);
            }
            
            for (int i = endRow; i > startRow; i--) {
                keep2 = map[i][startColumn];
                map[i][startColumn] = keep;
                keep = keep2;
                min = Math.min(min, keep);
            }
            
            map[startRow][startColumn] = keep;
            
            answer.add(min);
        }
        
        //Collections.sort(answer);
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}
}
