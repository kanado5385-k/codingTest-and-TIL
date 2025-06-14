import java.util.*;

public class s1260 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sbForDfs;
    static StringBuilder sbForBfs;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i < N + 1; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        sbForDfs = new StringBuilder();
        dfs(start);

        visited = new boolean[N+1];
        sbForBfs = new StringBuilder();
        bfs(start);

        System.out.println(sbForDfs.toString());
        System.out.println(sbForBfs.toString());
        sc.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        sbForDfs.append(node).append(" ");

        List<Integer> list = graph.get(node);
        Collections.sort(list);

        for (int node1 : list) {
            if (visited[node1] == false) {
                dfs(node1);
            }
        }
    }

    static void bfs(int node) {
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            sbForBfs.append(nowNode).append(" ");
            List<Integer> list = graph.get(nowNode);
            Collections.sort(list);
            for (int node1: list) {
                if (visited[node1] == false) {
                    visited[node1] = true;
                    queue.add(node1);
                }
            }
        }
    }
}

// 시간복잡도 = O(N + M)
