package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon11725 {
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        for (int node: parent) {
            if (node != 0) {
                System.out.println(node);
            }
        }
    }

    static public void dfs(int node) {
        visited[node] = true;

        for (int child: tree.get(node)) {
            if (visited[child] == false) {
                parent[child] = node;
                dfs(child);
            }
        }
    }
}
