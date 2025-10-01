package level1;
import java.util.Map;
import java.util.HashMap;

public class stringProcessing4 {

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> totalPoint = new HashMap<>();
        String[][] type = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        
        for (int i = 0; i < survey.length; i++) {
            String[] split = survey[i].split("");
            String firstType = split[0];
            String secondType = split[1];
            
            int point = choices[i];
            switch (point) {
                case 1:
                    totalPoint.put(firstType, totalPoint.getOrDefault(firstType, 0) + 3);
                    break;
                case 2:
                    totalPoint.put(firstType, totalPoint.getOrDefault(firstType, 0) + 2);
                    break;
                case 3:
                    totalPoint.put(firstType, totalPoint.getOrDefault(firstType, 0) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    totalPoint.put(secondType, totalPoint.getOrDefault(secondType, 0) + 1);
                    break;
                case 6:
                    totalPoint.put(secondType, totalPoint.getOrDefault(secondType, 0) + 2);
                    break;
                case 7:
                    totalPoint.put(secondType, totalPoint.getOrDefault(secondType, 0) + 3);
                    break;
            }
        }
        
            for (int i = 0; i < 4; i++) {
                String firstType = type[i][0];
                String secondType = type[i][1];
                
                if (totalPoint.containsKey(firstType) && totalPoint.containsKey(secondType)) {
                    int sumOfFirstType = totalPoint.get(firstType);
                    int sumOfSecondType = totalPoint.get(secondType);
                
                    if (sumOfFirstType > sumOfSecondType) {
                        answer.append(firstType);
                    } else if (sumOfSecondType > sumOfFirstType) {
                        answer.append(secondType);
                    } else {
                        int compare = firstType.compareTo(secondType);
                        if (compare < 0) {
                            answer.append(firstType);
                        } else {
                            answer.append(secondType);
                        }
                    }
                } else if (totalPoint.containsKey(firstType)) {
                    answer.append(firstType);
                } else if (totalPoint.containsKey(secondType)) {
                    answer.append(secondType);
                } else {
                    int compare = firstType.compareTo(secondType);
                        if (compare < 0) {
                            answer.append(firstType);
                        } else {
                            answer.append(secondType);
                        }
                }
            }
        
        return answer.toString();
    }
}
}
