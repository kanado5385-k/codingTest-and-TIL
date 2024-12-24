import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DFS2606 {
    static int sum = 0;
    public static void main (String[] args) {
        boolean[] visited;
        List<List<Integer>> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N + 1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = dfs(visited, graph, 1);

        System.out.println(--result);
        sc.close();
    }

    static Integer dfs(boolean[] visited, List<List<Integer>> graph, int start) {
        visited[start] = true;
        sum++;

        for (int node: graph.get(start)) {
            if (visited[node] == false) {
                dfs(visited, graph, node);
            }
        }

        return sum;
    }
}
