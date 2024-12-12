import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS1260 {
    static List<List<Integer>> graph = new ArrayList<>(); 
    static boolean[] visited;
    static StringBuilder DFSresult = new StringBuilder();
    static StringBuilder BFSresult = new StringBuilder();

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           graph.get(a).add(b);
           graph.get(b).add(a); 
        }
        
        resetVisited(N);
        dfs(V);

        resetVisited(N);
        bfs(V);

        System.out.println(DFSresult.toString());
        System.out.println(BFSresult.toString());

        sc.close();
    }

    static void resetVisited(int n) {
        visited = new boolean[1 + n];
    }

    static void dfs(int node) {
        visited[node] = true;
        DFSresult.append(node).append(" ");
        List<Integer> childNodes = graph.get(node);
        Collections.sort(childNodes);
        for (int childNode : childNodes) {
            if (visited[childNode] == false) {
                dfs(childNode);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        visited[node] = true;
        BFSresult.append(node).append(" ");

        while (!queue.isEmpty()) {
            int pullValue = queue.poll();

            List<Integer> childNodes = graph.get(pullValue);
            Collections.sort(childNodes);
    
            for (int childNode : childNodes) {
                if (visited[childNode] == false) {
                    queue.offer(childNode);
                    visited[childNode] = true;
                    BFSresult.append(childNode).append(" ");
                }
            }
        }

    }
}
