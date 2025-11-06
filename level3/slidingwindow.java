package level3;
import java.util.*;

public class slidingwindow {
class Solution {
    HashMap<String,Integer> type = new HashMap<>();
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        int[] answer = new int[2];
        int typeCount = 0;
        
        for (int i = 0; i < gems.length; i++) {
            String cur = gems[i];
            set.add(cur);
        }
        
        for (String curType : set) {
            type.put(curType, 0);
        }
        
        int max = set.size();
        
        int left = 0;
        for (int right = 0; right < gems.length; right++) {
            String cutTupe = gems[right];
            type.put(cutTupe, type.get(cutTupe) + 1);
            if (type.get(cutTupe) == 1) {
                typeCount++;
            }
            
            while (typeCount == max) {
                int curLen = right - left;
                if (curLen == minLen) {
                    if (left < minStart) {
                        minStart = left;
                        minEnd = right;
                    }
                } else if (curLen < minLen) {
                    minLen = curLen;
                    minStart = left;
                    minEnd = right;
                }
                
                String nextTupe = gems[left++];
                type.put(nextTupe, type.get(nextTupe) - 1);
                
                if (type.get(nextTupe) == 0) {
                    typeCount--;
                }
            }
        }
        
        answer[0] = minStart + 1;
        answer[1] = minEnd + 1;
        
        return answer;
    }
}
}
