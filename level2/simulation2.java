package level2;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class simulation2 {

class Solution {
    Map<Integer, List<Integer>> graphOut = new HashMap<>();
    Map<Integer, List<Integer>> graphIn = new HashMap<>();
    Set<Integer> allNum = new HashSet<>();
    boolean[] visited;
    int creationNode = 0;
    Set<Integer> contain;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        for (int i = 0 ; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            allNum.add(from);
            allNum.add(to);
            
            graphOut.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            
            graphIn.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            graphIn.computeIfAbsent(from, k -> new ArrayList<>());
            
        }
        
        visited = new boolean[allNum.size() + 2];
        
        for (int node : graphIn.keySet()) {
            List<Integer> list = graphIn.get(node);
            if (list.isEmpty() && graphOut.getOrDefault(node, new ArrayList<>()).size() >= 2) {
                creationNode = node;
                break;
            }
        }
        
        answer[0] = creationNode;
        
        for (int node: graphOut.get(creationNode)) {       
            int nodeCount = 0;
            int trunkCount = 0;
            int noOutTrunk = 0;
            contain = new HashSet<>();
            contain.add(node);
            
            dfs(node);
            
            nodeCount = contain.size();
            
            for (int curNode: contain) {
                if (!graphOut.containsKey(curNode)) {
                    noOutTrunk++;
                    continue;
                }
                trunkCount += graphOut.get(curNode).size();
            }
            
            if (nodeCount == trunkCount) {
                answer[1]++;
            } else if (nodeCount - 1 == trunkCount && noOutTrunk == 1) {
                answer[2]++;
            } else {
                answer[3]++;
            }
            
            
        }
        
        return answer;
    }
    
        public void dfs(int node) {
            visited[node] = true;
            
            if (!graphOut.containsKey(node)) return;
            
            for (int nextNode : graphOut.get(node)) {
                if (visited[nextNode] == false) {
                    contain.add(nextNode);
                    dfs(nextNode);
                }
            }
        }
}
}
