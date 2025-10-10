package level2;

public class greedy5 {
    class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int lastHouseDelivery = deliveries.length - 1;
        int lastHousePickups = pickups.length - 1;
        
        while (true) {
            
            while (lastHouseDelivery >= 0 && deliveries[lastHouseDelivery] == 0) lastHouseDelivery--;
            while (lastHousePickups >= 0 && pickups[lastHousePickups] == 0) lastHousePickups--;

            long maxPath = Math.max(lastHouseDelivery, lastHousePickups);
            if (maxPath < 0) break;
            
            answer += (maxPath + 1L)*2;
            
            int deliveryCap = cap;
            for (int i = lastHouseDelivery; i >= 0 && deliveryCap > 0; i--) {
                if (deliveries[i] <= deliveryCap) {
                    deliveryCap -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= deliveryCap;
                    deliveryCap = 0;
                }
            }
            
            int pickupCap = cap;
            for (int i = lastHousePickups; i >= 0 && pickupCap > 0; i--) {
                if (pickups[i] <= pickupCap) {
                    pickupCap -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= pickupCap;
                    pickupCap = 0;
                }
            }
            
            
            
        }
        
        return answer;
    }
}
}
