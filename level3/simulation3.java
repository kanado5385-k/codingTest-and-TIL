package level3;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class simulation3 {

class Solution {
    List<List<Integer>> allCaseOfDist = new ArrayList<>();
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = dist.length + 1;
        int len = weak.length;
        int[] extendWeak = new int[len * 2];
        
        for (int i = 0; i < extendWeak.length; i++) {
            extendWeak[i] = (i < len) ? weak[i] : weak[i - len] + n;
        }
        
        List<Integer> distList = new ArrayList<>();
        for (int i : dist) distList.add(i);
        
        getAllDistCase(0, distList);
        
        for (List<Integer> curDist : allCaseOfDist) {
            for (int start = 0; start < len; start++) {
                int friend = 1;
                int finishDist = extendWeak[start] + curDist.get(friend - 1);
                for (int i = start; i < start + len; i++) {
                    if (extendWeak[i] > finishDist) {
                        friend++;
                        if (friend > dist.length) break;
                        finishDist = extendWeak[i] + curDist.get(friend - 1);
                    }
                }
                
                answer = Math.min(answer, friend);
            }
        }
        
        return (answer == dist.length + 1) ? -1 : answer;
    }
    
    public void getAllDistCase(int step, List<Integer> distList) {
        if (step == distList.size()) {
            allCaseOfDist.add(new ArrayList<>(distList));
            return;
        }
        
        for (int i = step; i < distList.size(); i++) {
            Collections.swap(distList, i, step);
            getAllDistCase(step + 1, distList);
            Collections.swap(distList, i, step);
        }
        return;
    }
}
}
