import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS14496 {
    static int result = 0;
    static List<List<Integer>> graf = new ArrayList<>();
    static boolean[] visited;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int target = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N +1; i++) {
            graf.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf.get(a).add(b);
            graf.get(b).add(a);
        }

        visited = new boolean[N + 1];

        bfs(start,target);
        System.out.println(result);

        sc.close();
    }

    static void bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pollValue = queue.poll();
            int currentNode = pollValue[0];
            int currentDistance = pollValue[1];

            if (currentNode == target) {
                result = currentDistance;
                return;
            }

            for (int node : graf.get(currentNode)) {
                if (!visited[node]) {
                    queue.offer(new int[]{node, currentDistance + 1});
                    visited[node] = true;
                }
            }
        }

        result = -1;
    }
}
