package gold.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1167 {
    static List<int[]>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new int[]{to, weight});
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        maxDist = 0;
        visited = new boolean[V + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDist);

    }

    static public void dfs(int node, int value) {
        visited[node] = true;

        if (value > maxDist) {
            maxDist = value;
            farthestNode = node;
        }

        for (int[] cur: tree[node]) {
            int nextNode = cur[0];
            int nextValue = cur[1];
            if (visited[nextNode] != true) {
                dfs(nextNode, value + nextValue);
            }
        }
    }
}
