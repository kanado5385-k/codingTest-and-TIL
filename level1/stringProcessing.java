package level1;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class stringProcessing {

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportSumPerPerson = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String[] curReport = report[i].split(" ");
            String reporter = curReport[0];
            String reported = curReport[1];
            
            reportMap.putIfAbsent(reporter, new HashSet<>());
            reportMap.get(reporter).add(reported);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            if (reportMap.containsKey(id_list[i])) {
                Set<String> tmp = reportMap.get(id_list[i]);
                for (String userName: tmp) {
                    reportSumPerPerson.put(userName, reportSumPerPerson.getOrDefault(userName, 0) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String userName = id_list[i];
            int sumOfMessage = 0;
            
            if (reportMap.containsKey(userName)) { 
                Set<String> tmp = reportMap.get(userName);
                for (String reportedUserName: tmp) {
                    int reportSum = reportSumPerPerson.get(reportedUserName);
                    if (reportSum >= k) {
                        sumOfMessage++;
                    }
                }
            }
            
            answer[i] = sumOfMessage;
        }
        
        return answer;
    }
}
}
