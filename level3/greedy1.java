package level3;
import java.util.Arrays;

public class greedy1 {

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] intTimeTable = new int[timetable.length];
        String answer = "";
        
        for (int i = 0; i < timetable.length; i++) {
            int time = changeToInt(timetable[i]);
            intTimeTable[i] = time;
        }
        
        int curBusTime = changeToInt("09:00");
        int lastCrueIndex = 0;
        
        Arrays.sort(intTimeTable);
        
        for (int i = 0; i < n; i++) {
            int curM = 0;
            while (lastCrueIndex < timetable.length && curM < m && intTimeTable[lastCrueIndex] <= curBusTime) {
                lastCrueIndex++;
                curM++;
            }
            
            if (i == n - 1) {
                if (curM == m) {
                    answer = changeToTime(intTimeTable[lastCrueIndex - 1] - 1);
                } else {
                    answer = changeToTime(curBusTime);
                }
            }
            
            curBusTime += t;
        }
        
    
        return answer;
    }
    
    public int changeToInt(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        return h * 60 + m;
    }
    
    public String changeToTime(int totalMinutes) {
        int h = totalMinutes / 60;
        int m = totalMinutes % 60;
    
        return String.format("%02d:%02d", h, m);
    }   
}
}
