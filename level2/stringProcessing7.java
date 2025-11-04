package level2;
import java.util.*;

public class stringProcessing7 {
class Solution {
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        List<String> record = new ArrayList<>();
        int kyo = 0;
        int hap = 0;
        int answer = 0;
        makeMap(str1, map1);
        makeMap(str2, map2);
        
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        
        for (String str : map1.keySet()) {
            int count1 = map1.get(str);
            if (map2.containsKey(str)) {
                int count2 = map2.get(str);
                if (count1 == count2) {
                    kyo += count2;
                    hap += count2;
                }
                else if (count1 > count2) {
                    kyo += count2;
                    hap += count1;
                } else {
                    kyo += count1;
                    hap += count2;
                }
                
            } else {
                hap += count1;
            }
            record.add(str);
        }
        
        for (String str : map2.keySet()) {
            if (record.contains(str)) continue;
            int count2 = map2.get(str);
            if (map1.containsKey(str)) {
                int count1 = map1.get(str);
                if (count1 > count2) {
                    kyo += count2;
                    hap += count1;
                } else if (count1 == count2) {
                    kyo += count2;
                    hap += count2;
                } else {
                    kyo += count1;
                    hap += count2;
                }
                
            } else {
                hap += count2;
            }
        }
        
        answer = (int) (((double) kyo / hap) * 65536);
        
        return answer;
    }
    
    public void makeMap(String str, HashMap<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            sub = sub.toUpperCase();
            if (sub.matches(".*[^a-zA-Z].*")) {
                continue;
            } else {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
    }
}
}
