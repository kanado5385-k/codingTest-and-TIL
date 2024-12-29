import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS24480 {
    static int N;
    static int M;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int order = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
        sc.close();
        
    }

    static void dfs(int start) {
        visited[start] = order++;

        List<Integer> list = new ArrayList<>(graph.get(start));
        Collections.sort(list, Collections.reverseOrder());

        for (int node: list) {
            if (visited[node] == 0) {
                dfs(node);
            }
        }
    }
}
