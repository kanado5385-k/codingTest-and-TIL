package level2;
import java.util.*;

public class stringProcessing6 {
class Solution {
    public String solution(String s) {
        String[] split = s.split(" ", -1);
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            if (word.equals("")) {
                answer.append(" ");
                continue;
            }
            word = word.toLowerCase();
            char firstCh = word.charAt(0);
            
            if (!Character.isDigit(firstCh)) {
                String firstStr = String.valueOf(firstCh);
                firstStr = firstStr.toUpperCase();
                answer.append(firstStr).append(word.substring(1)).append(" ");
            } else {
                answer.append(word).append(" ");
            }
        }
        
        String answerStr = answer.toString().substring(0, answer.length() - 1);
        
        return answerStr;
    }
}
}
