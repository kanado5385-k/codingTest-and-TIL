package gold.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon11437 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent, depth;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(1,0);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int josan = getJosan(a,b);
            System.out.println(josan);
        }

        sc.close();
    }

    static int getJosan(int a, int b) {
        while(depth[a] > depth[b]) a = parent[a];
        while(depth[b] > depth[a]) b = parent[b];

        while (a != b) {
            a = parent[a];
            b= parent[b];
        }

        return a;
    }

    static void dfs(int node, int step) {
        visited[node] = true;
        depth[node] = step;

        for (int nextNode: tree[node]) {
            if (visited[nextNode] == false) {
                parent[nextNode] = node;
                dfs(nextNode, step + 1);
            }
        }
    }
}
