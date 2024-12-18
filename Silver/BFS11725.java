import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS11725 {
    public static void main (String[] args) {
        int[] result;
        boolean[] visited;
        List<List<Integer>> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N -1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> queue = new  LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int node : graph.get(curNode)) {
                if (visited[node] == false) {
                    result[node] = curNode;
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }

        for(int i = 2; i < N + 1; i++){
            System.out.println(result[i]);
        }
        sc.close();

    }
}
