package level3;
import java.util.List;
import java.util.ArrayList;

public class dfs2 {

class Solution {
    List<Integer>[] map;
    int maxShipCount = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {
        map = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) map[i] = new ArrayList<>();
        
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            map[from].add(to);
        }
        
        List<Integer> canGo = new ArrayList<>();
        dfs(0, 0, 0, canGo, info);
        int answer = maxShipCount;
        return answer;
    }
    
    public void dfs(int curNode, int ship, int wolf, List<Integer> canGo, int[] info) {
        int totalShip = ship;
        int totalWolf = wolf;
        if (info[curNode] == 0) totalShip++;
        if (info[curNode] == 1) totalWolf++;
        if (totalWolf >= totalShip) {
            maxShipCount = Math.max(maxShipCount, totalShip);
            return;
        }
        
        maxShipCount = Math.max(maxShipCount, totalShip);
        
        List<Integer> newCanGo = new ArrayList<>(canGo);
        if (!map[curNode].isEmpty()) {
            for (int nextNode: map[curNode]) {
                newCanGo.add(nextNode);
            }
        }
        
        List<Integer> newCanGo2 = new ArrayList<>(newCanGo);
        for (int nextNode : newCanGo) {
            newCanGo2.remove(Integer.valueOf(nextNode));
            dfs(nextNode, totalShip, totalWolf, newCanGo2, info);
            newCanGo2.add(nextNode);
        }
    }
}


}
