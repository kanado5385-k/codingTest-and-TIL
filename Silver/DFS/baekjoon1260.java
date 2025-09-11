package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1260 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(V);
        System.out.println(sb.toString());
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int nextNode: graph[node]) {
            if (visited[nextNode] == false) {
                dfs(nextNode);
            }
        }
    }
}
