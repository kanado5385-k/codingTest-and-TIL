package level2;
import java.util.*;

public class dfs4 {
class Solution {
    Map<String, List<String>> clothesMap = new HashMap<>();
    List<String> keys = new ArrayList<>();
    int answer = 0;
    
    public int solution(String[][] clothes) {
        for (String[] item : clothes) {
            String name = item[0];
            String type = item[1];
            clothesMap.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
        }

        keys.addAll(clothesMap.keySet());
        
        dfs(0, 1);
    
        return answer - 1;
    }
    
    public void dfs(int idx, int product) {
        if (idx == keys.size()) {
            answer += product;
            return;
        }
        
        String type = keys.get(idx);
        int count = clothesMap.get(type).size();
        
        dfs(idx + 1, product * count);
        dfs(idx + 1, product);
    }
}

}
