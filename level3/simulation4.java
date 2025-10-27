package level3;
import java.util.*;

public class simulation4 {
class Solution {
    List<List<Integer>> allDist = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        int[] extendWeak = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            extendWeak[i] = (i < len) ? weak[i] : weak[i - len] + n;
        }

        List<Integer> listDist = new ArrayList<>();
        for (int d : dist) listDist.add(d);
        allDist.clear();
        calculateAllDist(0, dist.length, listDist);

        int answer = dist.length + 1;

        for (List<Integer> curDist : allDist) {
            for (int start = 0; start < len; start++) {
                int friend = 0;
                int pos = extendWeak[start] + curDist.get(friend);

                for (int i = start; i < start + len; i++) {
                    if (extendWeak[i] > pos) {
                        friend++;
                        if (friend >= curDist.size()) break;
                        pos = extendWeak[i] + curDist.get(friend);
                    }
                }

                answer = Math.min(answer, friend + 1);
            }
        }

        return (answer > dist.length) ? -1 : answer;
    }

    public void calculateAllDist(int step, int max, List<Integer> listDist) {
        if (step == max) {
            return;
        }
        
        allDist.add(new ArrayList<>(listDist));

        for (int i = step; i < max; i++) {
            Collections.swap(listDist, i, step);
            calculateAllDist(step + 1, max, listDist);
            Collections.swap(listDist, i, step);
        }
    }
}

}
