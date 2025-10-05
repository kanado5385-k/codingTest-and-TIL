package level2;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;



public class simulation1 {
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> carNumbers = new HashSet<>();
        Map<Integer, Integer> recordsMap = new HashMap<>();
        Map<Integer, Integer> payPerCarMap = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            int time = parseToInt(split[0]);
            int carNumber = Integer.parseInt(split[1]);
            String type = split[2];
            if (type.equals("IN")) {
                carNumbers.add(carNumber);
                recordsMap.put(carNumber, time);
            } else {
                int inTime = recordsMap.get(carNumber);
                int totalTime = time - inTime;
                payPerCarMap.put(carNumber, payPerCarMap.getOrDefault(carNumber, 0) + totalTime);
                recordsMap.put(carNumber, -1);
            }
        }
        
        List<Integer> carNumList = new ArrayList<>(carNumbers);
        Collections.sort(carNumList);
        int[] answer = new int[carNumList.size()];
        
        for(int i = 0; i < carNumList.size(); i++) {
            int carNumber = carNumList.get(i);
            int remainPay = recordsMap.get(carNumber);
            if (remainPay != -1) {
                int lastTime = parseToInt("23:59");
                int totalTime = lastTime - remainPay;
                payPerCarMap.put(carNumber, payPerCarMap.getOrDefault(carNumber, 0) + totalTime);
                recordsMap.put(carNumber, 0);
            }
        }
        
        for(int i = 0; i < carNumList.size(); i++) {
            int carNumber = carNumList.get(i);
            int totalTime = payPerCarMap.get(carNumber);
            int totalPay = countTotalPay(totalTime, fees);
            answer[i] = totalPay;
        }
        
        return answer;
    }
    
    public int countTotalPay(int totalTime, int[] fees) {
        int totalPay = 0;
        int genTime = fees[0];
        int genPay = fees[1];
        int unitTime = fees[2];
        int unitPay = fees[3];
        
        int num = totalTime - genTime;
        totalPay += genPay;
        
        if (num > 0) {
            int num2 = num / unitTime;
            if (num % unitTime != 0) {
                num2++;
            }
            totalPay += num2 * unitPay;
        }
        
        return totalPay;  
    }
    
    public int parseToInt(String time) {
        String[] split = time.split(":");
        int oc = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return oc * 60 + min;
    }
}
}
