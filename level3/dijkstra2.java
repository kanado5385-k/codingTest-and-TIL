package level3;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class dijkstra2 {

class Solution {
    List<int[]>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int value = fares[i][2];
            
            graph[from].add(new int[]{to, value});
            graph[to].add(new int[]{from, value});
        }
        
        int[] dijkstraFromS = getDijkstra(n, s);
        int[] dijkstraFromA = getDijkstra(n, a);
        int[] dijkstraFromB = getDijkstra(n, b);
        
        for (int i = 1; i < n + 1; i ++) {
            int dist = dijkstraFromS[i] + dijkstraFromA[i] + dijkstraFromB[i];
            answer = Math.min(answer, dist);
        }
        
        return answer;
    }
    
    public int[] getDijkstra(int n, int start) {
        int[] distList = new int[n + 1];
        Arrays.fill(distList, Integer.MAX_VALUE);
        
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        distList[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int value = cur[1];
            
            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextValue = next[1];
                
                if (distList[nextNode] > value + nextValue) {
                    distList[nextNode] = value + nextValue;
                    pq.offer(new int[]{nextNode, value + nextValue});
                }
            }
        }
        
        return distList;   
    }
}
}
