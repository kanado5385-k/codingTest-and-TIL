package level2;
import java.util.*;

public class stringProcessing4 {

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (a, b) -> {
            String lowerA = a.toLowerCase();
            String lowerB = b.toLowerCase();
            String[] arrA = getHeadAndNum(lowerA);
            String[] arrB = getHeadAndNum(lowerB);
            
            String headA = arrA[0];
            String headB = arrB[0];
            
            int numA = Integer.parseInt(arrA[1]);
            int numB = Integer.parseInt(arrB[1]);
            
            if (!headA.equals(headB)) {
                return headA.compareTo(headB);
            } else {
                return Integer.compare(numA, numB);
            }
        });
        
        return files;
    }
    
    public String[] getHeadAndNum(String str) {
    String head = "";
    String number = "";

    for (int i = 0; i < str.length(); i++) {
        String curStr = str.substring(i, i + 1);

        if (curStr.matches("\\d")) {
            head = str.substring(0, i);
            number = getNumber(str.substring(i));
            break;
        }
    }

    return new String[] { head, number };
}


public String getNumber(String str) {

    String number = "";
    for (int i = 0; i < str.length(); i++) {
        String cur = str.substring(i, i + 1);

        // 숫자가 아닌 문자가 나오면 종료
        if (cur.matches("[a-zA-Z\\s.-]") || i >= 5) {
            break;
        }

        if (cur.matches("\\d")) {
            number += cur;
        } else {
            break;
        }
    }

    // 앞자리 0 제거
    number = number.replaceFirst("^0+", "");
    if (number.isEmpty()) number = "0";

    return number;
}


}
}
