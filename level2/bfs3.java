package level2;
import java.util.Queue;
import java.util.LinkedList;

public class bfs3 {

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        bridge.remove();
        bridge.offer(truck_weights[0]);
        int time = 1;
        int curTotalWeight = truck_weights[0];
        
        int index = 1; 
        while (index <= truck_weights.length - 1) {
            int curTruck = bridge.poll();
            time++;
            if (curTruck == 0) {
                if (index <= truck_weights.length) {
                    int nextTruck = truck_weights[index];
                    if (curTotalWeight + nextTruck > weight) {
                        bridge.offer(0);
                    } else {
                        bridge.offer(nextTruck);
                        index++;
                        curTotalWeight += nextTruck;
                    }
                }
            } else {
                curTotalWeight -= curTruck;
                if (index <= truck_weights.length - 1) {
                    int nextTruck = truck_weights[index];
                    if (curTotalWeight + nextTruck > weight) {
                        bridge.offer(0);
                    } else {
                        bridge.offer(nextTruck);
                        index++;
                        curTotalWeight += nextTruck;
                    }
                }
            }
        }
        
        while (!bridge.isEmpty()) {
            int curTruck = bridge.poll();
            time++;
        }
        
        int answer = time;
        return answer;
    }
}

}
