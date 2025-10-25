package level2;
import java.util.*;

public class StringProcessing5 {
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int index = 26;
        HashMap<String, Integer> library = new HashMap<>();
        
        for (int i = 0; i <= index; i++) {
            char word = (char) ('A' + i);
            library.put(String.valueOf(word), i + 1);
        }
        
        int idx = 0;
        while (idx < msg.length()) {
            String word = String.valueOf(msg.charAt(idx)); 
            String preWord = word;
            while(true) {
                if (!library.containsKey(word)) break;
                if (idx + 1 >= msg.length()) break;
                preWord = word;
                idx++;
                word = word + String.valueOf(msg.charAt(idx));
            }
            
            if (idx + 1 >= msg.length() && library.containsKey(word)) {
                answer.add(library.get(word));
                break;
            }
            
            answer.add(library.get(preWord));
            
            if (!library.containsKey(word)) {
                index++;
                library.put(word,index);
            }
        }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}
}
