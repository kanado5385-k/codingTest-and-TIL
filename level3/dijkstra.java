package level3;
import java.util.*;

public class dijkstra {

class Solution {
    List<int[]>[] graph;
    Set<Integer> gatesSet = new HashSet<>();
    Set<Integer> summitsSet = new HashSet<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            graph[paths[i][0]].add(new int []{paths[i][1], paths[i][2]});
            graph[paths[i][1]].add(new int []{paths[i][0], paths[i][2]});
        }
        
        for (int gate: gates) gatesSet.add(gate);
        for (int summit: summits) summitsSet.add(summit);
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int gate: gatesSet) {
            intensity[gate] = 0;
            pq.offer(new int[]{gate, 0});
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int value = cur[1];
            
            if (value > intensity[node]) continue;
            if (summitsSet.contains(node)) continue;
             
            for (int[] next: graph[node]) {
                int nextNode = next[0];
                int nextValue = next[1];
                int newValue = Math.max(value, nextValue);
                if (intensity[nextNode] > newValue) {
                    intensity[nextNode] = newValue;
                    pq.offer(new int[]{nextNode, newValue});
                }
            }
        }
        
        int minIntensity = Integer.MAX_VALUE;
        int minSummit = 0;
        for (int summit: summitsSet) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            } else if (intensity[summit] == minIntensity) {
                if (summit < minSummit) {
                    minSummit = summit;
                }
            }
        }
        
        answer[0] = minSummit;
        answer[1] = minIntensity;

        return answer;
    }
}
}
