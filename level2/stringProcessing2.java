package level2;
import java.util.*;

public class stringProcessing2 {
class Solution {
    public String solution(String p) {

        String result = step1(p);
        String answer = result;
        return answer;
    }
    
    public String step1(String p) {
        StringBuilder step1Result = new StringBuilder();
        if (p.isEmpty()) {
            return "";
        }
        
        int left = 0;
        int rigth = 0;
        
        int index = 0;
        while (true) {
            char ch = p.charAt(index);
            if (ch == '(') {
                left++;
            } else {
                rigth++;
            }
            
            if (left == rigth) break;
            index++;
        }
        
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        
        if (isRigth(u)) {
            step1Result.append(u);
            String resultOfV = step1(v);
            step1Result.append(resultOfV);
            return step1Result.toString();
        } else {
            StringBuilder step2Result = new StringBuilder();

            step2Result.append("(");
            step2Result.append(step1(v));
            step2Result.append(")");

            String trimmed = u.substring(1, u.length() - 1);
            for (char ch : trimmed.toCharArray()) {
                if (ch == '(') step2Result.append(')');
                else step2Result.append('(');
            }
            return step2Result.toString();
        }
        
        
    }
    
    public boolean isRigth(String u) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < u.length(); i++) {
            char ch = u.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
}
