package level3;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class bruteForce2 {

class Solution {
    int ryanBestGapScore = 0;
    List<int[]> ryanBestWinScores = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        int[] answer;
        int[] ryan = new int[11];
        
        dfs(n, 0, info, ryan, 0);
        if (ryanBestGapScore == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[11];
            if (ryanBestWinScores.size() != 1) {
                Collections.sort(ryanBestWinScores, (a, b) -> {
                    for (int i = 10; i >= 0; i--) {
                        if (a[i] == b[i]) continue;
                        return b[i] - a[i];
                    }
                    return 0;
                });
            }
        }
        
        return ryanBestWinScores.get(0);
    }
    
    public void dfs(int tatolN, int curN, int[] opich, int[] ryan, int step) {

        if (curN == tatolN) {
            int gap = getRyanScore(opich, ryan);
            if (gap > 0) {
                if (gap > ryanBestGapScore) {
                    ryanBestGapScore = gap;
                    ryanBestWinScores.clear();
                    ryanBestWinScores.add(Arrays.copyOf(ryan, ryan.length));
                } else if (gap == ryanBestGapScore) {
                    ryanBestWinScores.add(Arrays.copyOf(ryan, ryan.length));
                }
            }
            return;
        }

        if (step == 10) {
            if (curN > tatolN) return;

            int[] copy = Arrays.copyOf(ryan, ryan.length);
            copy[10] = tatolN - curN;
            int gap = getRyanScore(opich, copy);
            if (gap > 0) {
                if (gap > ryanBestGapScore) {
                    ryanBestGapScore = gap;
                    ryanBestWinScores.clear();
                    ryanBestWinScores.add(copy);
                } else if (gap == ryanBestGapScore) {
                    ryanBestWinScores.add(copy);
                }
            }
            return;
        }

        if (curN > tatolN) return; 
        
        int opichN = opich[step];
        int ryanN = opichN + 1;
        int[] copyRyan = Arrays.copyOf(ryan, ryan.length);
        copyRyan[step] = ryanN;
        dfs(tatolN, curN + ryanN, opich, copyRyan, step + 1);
        
        int[] copyRyan2 = Arrays.copyOf(ryan, ryan.length);
        copyRyan2[step] = 0;
        dfs(tatolN, curN, opich, copyRyan2, step + 1);
    }
    
    public int getRyanScore(int[] opich, int[] ryan) {
        int opichTotalScore = 0;
        int ryanTotalScore = 0;
        for (int i = 0; i < 11; i++) {
            int opichScore = opich[i];
            int ryanScore = ryan[i];
            if (opichScore == 0 && ryanScore == 0) continue;

            if (ryanScore > opichScore) {
                ryanTotalScore += (10 - i);
            } else {
                opichTotalScore += (10 - i);
            }
        }
        return ryanTotalScore - opichTotalScore;
    }

}
}
