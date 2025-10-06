package level2;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class dfs {
    
class Solution {
    Map<String, Integer> courseMenu = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            String word = orders[i];
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            orders[i] = new String(ch);
        }
        
        for (int i = 0; i < course.length; i++) {
            int count = course[i];
            for (String menu : orders) {
                dfs(menu, count, 0, "");
            }     
        }
        
        for (int i = 0; i < course.length; i++) {
            int max = -1;
            int count = course[i];
            
            for (String menu: courseMenu.keySet()) {
                if (menu.length() != count) continue;
                int countOfMenu = courseMenu.get(menu);
                if (countOfMenu >= 2 && countOfMenu >= max) max = countOfMenu;
            }
            
            for (String menu: courseMenu.keySet()) {
                if (menu.length() != count) continue;
                int countOfMenu = courseMenu.get(menu);
                if (countOfMenu == max) {
                    answer.add(menu);
                }
            }  
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String menu, int count, int step, String curMenu) {
        if (curMenu.length() == count) {
            courseMenu.put(curMenu, courseMenu.getOrDefault(curMenu, 0) + 1);
            return;
        }
        
        for (int i = step; i < menu.length(); i++) {
            char ch = menu.charAt(i);
            String newCurMenu = curMenu;
            newCurMenu = newCurMenu + String.valueOf(ch);
            dfs(menu, count, i + 1, newCurMenu);
        }
    }
}
}
