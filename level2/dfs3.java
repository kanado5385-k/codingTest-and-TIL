package level2;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dfs3 {

class Solution {
    Map<String, List<Integer>> allInfoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            int score = Integer.parseInt(split[4]);
            String[] split2 = {split[0], split[1], split[2], split[3]};
            dfs(split2, score, 0);
        }
        
        for (int i = 0; i < query.length; i++) {
            int totalPer = 0;
            String replace = query[i].replace(" and ", " ");
            String[] split = replace.split(" ");
            int scoreQuery = Integer.parseInt(split[4]);
            String newQuery = split[0] + " and " + split[1] + " and " + split[2] + " and " + split[3];
            
            if (!allInfoMap.containsKey(newQuery)) {
                answer[i] = 0;
                continue;
            }
            List<Integer> list = allInfoMap.get(newQuery);
            Collections.sort(list);
            
            int numbers = getNeedScore(list, scoreQuery);
            answer[i] = list.size() - numbers;
        }
        
        return answer;
    }
    
    public void dfs(String[] info, int score, int idx) {
        if (idx > 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(info[0]).append(" and " + info[1]).append(" and " + info[2]).append(" and " + info[3]);
            
            allInfoMap.computeIfAbsent(sb.toString(), k -> new ArrayList()).add(score);
            return;
        }
        
        
        String[] copyInfo = Arrays.copyOf(info, info.length);
        dfs(copyInfo, score, idx + 1);
            
        String[] copyInfo2 = Arrays.copyOf(info, info.length);
        copyInfo2[idx] = "-";
        dfs(copyInfo2, score, idx + 1);
    }
    
    public int getNeedScore(List<Integer> list, int scoreQuery) {
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= scoreQuery) end = mid;
            else start = mid + 1;
        }
        
        return start;
    }
    
    
}
}
