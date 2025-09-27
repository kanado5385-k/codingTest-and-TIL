package level1;
import java.util.List;
import java.util.ArrayList;

public class stringProcessing2 {

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> score = new ArrayList<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            String cur = String.valueOf(dartResult.charAt(i));
            
            if (cur.equals("1") && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                score.add(10);
                i++;
                continue;
            }
            if (cur.matches("[0-9]")) {
                score.add(Integer.parseInt(cur));
                continue;
            }
            
            
            int pre = 0;
            int pre2 = 0;
            switch (cur) {
                case "S":
                    break;
                case "D":
                    pre = score.get(score.size() - 1);
                    score.remove(score.size() - 1);
                    pre *= pre;
                    score.add(pre);
                    break;
                case "T":
                    pre = score.get(score.size() - 1);
                    score.remove(score.size() - 1);
                    pre = pre * pre * pre;
                    score.add(pre);
                    break;
                case "*":
                    pre = score.get(score.size() - 1);
                    score.remove(score.size() - 1);
                    pre *= 2;
                    if (score.size() != 0) {
                        pre2 = score.get(score.size() - 1);
                        score.remove(score.size() - 1);
                        pre2 *= 2;
                        score.add(pre2);
                        score.add(pre);
                    } else {
                        score.add(pre);
                    }
                    break;
                case "#":
                    pre = score.get(score.size() - 1);
                    score.remove(score.size() - 1);
                    pre *= -1;
                    score.add(pre);
                    break;
            }
        }
        
        for (int i = 0; i < score.size(); i++) {
            answer += score.get(i);
        }
        return answer;
    }
}
}
