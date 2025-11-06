package level2;
import java.util.*;

public class stringProgressing10 {
class Solution {
    List<List<String>> allCase = new ArrayList<>();

    public long solution(String expression) {
        Stack<String> mainStack = new Stack<>();
        Stack<String> mainStack2 = new Stack<>();
        Long answer = 0L;
        List<String> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char curCh = expression.charAt(i);
            if (!Character.isDigit(curCh)) {
                mainStack.push(sb.toString());
                String op = String.valueOf(curCh);
                mainStack.push(op);
                if (!operators.contains(op)) operators.add(op);
                sb = new StringBuilder();
            } else {
                sb.append(curCh);
            }
        }
        mainStack.push(sb.toString());

        getAllCaseOfOper(0, operators);
        
        while (!mainStack.isEmpty()) { mainStack2.push(mainStack.pop()); }

        for (List<String> curOperList : allCase) {
            Stack<String> curStack = (Stack<String>) mainStack2.clone();
            for (String curOper : curOperList) {
                Stack<String> miniStack = new Stack<>();

                while (!curStack.isEmpty()) {
                    String cur = curStack.pop();
                    if (cur.equals(curOper)) {
                        String left = miniStack.pop();
                        String right = curStack.pop();
                        Long result = calculate(left, right, cur);
                        miniStack.push(String.valueOf(result));
                    } else {
                        miniStack.push(cur);
                    }
                }

                while (!miniStack.isEmpty()) {
                    curStack.push(miniStack.pop());
                }
            }

            Long result = Math.abs(Long.parseLong(curStack.pop()));
            answer = Math.max(answer, result);
        }

        return answer;
    }

    public Long calculate(String first, String second, String oper) {
        Long a = Long.parseLong(first);
        Long b = Long.parseLong(second);
        switch (oper) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
        }
        return 0L;
    }

    public void getAllCaseOfOper(int step, List<String> ops) {
        if (step == ops.size()) {
            allCase.add(new ArrayList<>(ops));
            return;
        }
        for (int i = step; i < ops.size(); i++) {
            Collections.swap(ops, step, i);
            getAllCaseOfOper(step + 1, ops);
            Collections.swap(ops, step, i);
        }
    }
}

}
