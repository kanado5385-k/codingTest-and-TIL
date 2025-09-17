package level2;
import java.util.*;

public class greedy3 {
    class Solution {
        public String solution(String number, int k) {
            String answer = "";
            int[] numberInt = new int[number.length()];
            Stack<Integer> stack = new Stack<>();
            
            int index = 0;
            for (String ch: number.split("")) {
                numberInt[index] = Integer.parseInt(ch);
                index++;
            }
            
            stack.push(numberInt[0]);
            
            index = 1;
            while (index < numberInt.length && k > 0) {
                int curNum = numberInt[index];
                if (stack.peek() < curNum) {
                    while (!stack.isEmpty() && k > 0) {
                        if (stack.peek() >= curNum) {
                            break;
                        }
                        stack.pop();
                        k--;
                    }
                    stack.push(curNum);
                    index++;
                }
                else if (stack.peek() > curNum) {
                    stack.push(curNum);
                    index++;
                }
                else if (stack.peek() == curNum) {
                    stack.push(curNum);
                    index++;
                }
            }
            
            if (index < numberInt.length) {
                for (int i = index; i < numberInt.length; i++) {
                    stack.push(numberInt[i]);
                }
            }
            
            if (k > 0) {
                for (int i = k; i > 0; i--) {
                    stack.pop();
                }
            }
            
            List<String> list = new ArrayList<>();
            while(!stack.isEmpty()) {
                String strNum = String.valueOf(stack.pop());
                list.add(strNum);
            }
            
            for (int i = list.size() - 1; i >= 0; i--) {
                answer += list.get(i);
            }
            
            return answer;
        }
    }
}
