package level2;
import java.util.*;

public class greedy {
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<int[]> deliveriStack = new Stack<>();
        Stack<int[]> pickupStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) {
                deliveriStack.push(new int[]{i + 1, deliveries[i]});
            }
            if (pickups[i] > 0) {
                pickupStack.push(new int[]{i + 1, pickups[i]});
            }
        }
        
        long answer = 0;
        
        while(!deliveriStack.isEmpty() || !pickupStack.isEmpty()) {
            int farthest = 0;
            if (!deliveriStack.isEmpty()) {
                farthest = Math.max(farthest, deliveriStack.peek()[0]);
            }
            if (!pickupStack.isEmpty()) {
                farthest = Math.max(farthest, pickupStack.peek()[0]);
            }
            
            answer = answer + farthest*2L;
            
            int capacity = cap;
            while(!deliveriStack.isEmpty() && capacity > 0) {
                int[] top = deliveriStack.pop();
                int box = top[1];
                
                if (capacity >= box) {
                    capacity -= box;
                }
                else {
                    top[1] = box - capacity;
                    deliveriStack.push(top);
                    break;
                }
            }
            
            capacity = cap;
            while(!pickupStack.isEmpty() && capacity > 0) {
                int[] top = pickupStack.pop();
                int pickup = top[1];
                
                if (capacity >= pickup) {
                    capacity -= pickup;
                }
                else {
                    top[1] = pickup - capacity;
                    pickupStack.push(top);
                    break;
                }
            }
        }
        
        
        return answer;
    }
}
}
