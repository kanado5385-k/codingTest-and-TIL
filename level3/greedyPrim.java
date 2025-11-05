package level3;
import java.util.*;

public class greedyPrim {
class Solution {
    List<int[]>[] graph;

    public int solution(int n, int[][] costs) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : costs) {
            int a = edge[0], b = edge[1], cost = edge[2];
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // (0번, 비용 0)

        int answer = 0;
        int connected = 0;
        while (!pq.isEmpty() && connected < n) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            
            if (visited[curNode]) continue;
            visited[curNode] = true;
            connected++;
            answer += curCost;
            
            for(int[] next : graph[curNode]) {
                if (!visited[next[0]]) pq.offer(new int[]{next[0], next[1]});
            }
            
        }

        return answer;
    }
}

}
