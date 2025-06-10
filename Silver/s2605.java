import java.util.*;

public class s2605 {
    private final static List<List<Integer>> graph = new ArrayList<>();
    private static boolean check[];
    private static int result = 0;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new boolean[n+1];

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        System.out.println(result-1);
        sc.close();
    }

    public static void dfs(int node) {
        if (check[node] == true) {
            return;
        }

        result++;
        check[node] = true;

        for (int next : graph.get(node)) {
            dfs(next);
        }
    }
}

// O(n + k)
