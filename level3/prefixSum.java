package level3;
import java.util.*;

public class prefixSum {

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n + 2][m + 2];
        int answer = 0;
        
        for (int k = 0; k < skill.length; k++) {
            int type = skill[k][0];
            int r1 = skill[k][1];
            int c1 = skill[k][2];
            int r2 = skill[k][3];
            int c2 = skill[k][4];
            int degree = skill[k][5];
            
            int effect = (type == 1) ? -degree : degree;
            
            arr[r1][c1] += effect;
            arr[r1][c2 + 1] -= effect;
            arr[r2 + 1][c1] -= effect;
            arr[r2 + 1][c2 + 1] += effect;
        }
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        
        for (int j = 0; j < m + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] + board[i][j] >= 1) answer++;
            }
        }
        

        
        return answer;
    }
}
}
