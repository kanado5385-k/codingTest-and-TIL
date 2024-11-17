package d3;

import java.util.*;

public class DFSWithStack {
    public static void main(String[] args) {
        // 인접 리스트로 그래프 표현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Collections.emptyList());
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());

        // DFS 수행
        dfs(1, graph);
    }

    public static void dfs(int start, Map<Integer, List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                System.out.println("Visit: " + node);
                visited.add(node);

                // 인접 노드 스택에 추가 (역순으로 추가하여 작은 번호부터 방문)
                List<Integer> neighbors = graph.get(node);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}