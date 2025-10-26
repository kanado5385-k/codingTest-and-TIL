package level2;
import java.util.*;

public class simulation4 {
class Solution {
    Set<String> pick = new HashSet<>();
    char[][] newBoard;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        newBoard = changeBoard(m, n, board);
        
        while (true) {
            checkBoard(m, n, newBoard);
            
            if (pick.size() == 0) break;
            answer = answer + pick.size();
            
            List<int[]> listPick = new ArrayList<>();
            for (String set: pick) {
                String[] split = set.split(",");
                listPick.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
            }
            Collections.sort(listPick, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });
            
            for (int[] curPick : listPick) {
                int curM = curPick[0];
                int curN = curPick[1];
                
                goDown(curM, curN);
            }
            
            pick = new HashSet<>();
            
        }
        return answer;
    }
    
    public void goDown(int x, int y) {
        if (x >= 1) {
            newBoard[x][y] = newBoard[x - 1][y];
            newBoard[x - 1][y] = '0';
            goDown(x - 1, y);
        }
    }
    
    public void checkBoard(int m, int n, char[][] board) {
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
            
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char curFriend = board[i][j];
                
                if (curFriend == '0') continue;
                
                List<int[]> curColabo = new ArrayList<>();
                curColabo.add(new int[]{i, j});
                
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    
                    char nextFriend = board[nx][ny];
                    if (curFriend == nextFriend) {
                        curColabo.add(new int[]{nx, ny});
                    }
                }
                
                if (curColabo.size() == 4) {
                    for (int[] colabo : curColabo) {
                        pick.add(String.valueOf(colabo[0]) + "," + String.valueOf(colabo[1]));
                    }
                }
                
            }
        }
    }
    
    public char[][] changeBoard(int m, int n, String[] board) {
        char[][] newBoard = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            String curLine = board[i];
            for (int j = 0; j < n; j++) {
                char curFriend = curLine.charAt(j);
                newBoard[i][j] = curFriend;
            }
        }
        
        return newBoard;
    }
    
    
    
    
}
}
