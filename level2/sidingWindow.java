package level2;
import java.util.*;

public class sidingWindow {
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            String curDisc = discount[i];
            if (map.containsKey(curDisc)) {
                int curCount = map.get(curDisc);
                curCount--;
                map.put(curDisc, curCount);
            }
        }
        
        if(isAllWantGet()){
            answer++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            String minusName = discount[i - 10];
            String plusName = discount[i];
            
            if (map.containsKey(minusName)) {
                int curMinusCount = map.get(minusName);
                curMinusCount++;
                map.put(minusName, curMinusCount);
            }
            
            if (map.containsKey(plusName)) {
                int curPlusCount = map.get(plusName);
                curPlusCount--;
                map.put(plusName, curPlusCount);
            }
            
            if(isAllWantGet()){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public boolean isAllWantGet() {
        boolean isGetAll = true;
        
        for (String name: map.keySet()) {
            int count = map.get(name);
            if (count > 0) {
                return false;
            }
        }
        
        return isGetAll;
    }
}
}
