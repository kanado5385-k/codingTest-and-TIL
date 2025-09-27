package level2;

import java.util.Queue;
import java.util.LinkedList;

public class simulation {

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city); 
                answer += 1;
            } else {
                 answer += 5;
             }
            
            cache.offer(city);
            if (cache.size() > cacheSize) {
                cache.poll();
            }
            
        }
        
        return answer;
    }
}
}
