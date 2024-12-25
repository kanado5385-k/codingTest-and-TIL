import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bfs18352 {
     public static void main (String[] args) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int k = sc.nextInt();
        int X = sc.nextInt();

        visited = new boolean[N + 1];

        for (int i = 0 ; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curCity = curNode[0];
            int curDis = curNode[1];
            if (curDis == k) {
                result.add(curCity);
            }

            for (int node: graph.get(curCity)) {
                if (visited[node] == false) {
                    visited[node] = true;
                    queue.offer(new int[]{node, curDis + 1});
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        }
        else {
            result.sort(null);
            for (int node: result) {
                System.out.println(node);
            }
        }
        sc.close();
    }
}
