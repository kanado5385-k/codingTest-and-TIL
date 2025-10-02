package gold.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon1967 {
    static Map<Integer, List<int[]>> tree = new HashMap<>();
    static boolean[] visited;
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[]{b, w});
            tree.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[]{a, w});
        }

        visited = new boolean[n + 1];
        int[] result = dfs(1, 0);

        int farNode = result[0];
        
        visited = new boolean[n + 1];
        int[] result2 = dfs(farNode, 0);

        System.out.println(result2[1]);
    }

    static int[] dfs(int node, int dis) {
        visited[node] = true;
        int curNode = node;
        int curDis = dis;

        if (!tree.containsKey(node)) {
            return new int[]{curNode, curDis};
        }

        for (int[] arr: tree.get(node)) {
            int nextNode = arr[0];
            int value = arr[1];
            if (!visited[nextNode]) {

            int[] nextDist = dfs(nextNode, dis + value);
                if (nextDist[1] > curDis) {
                    curNode = nextDist[0];
                    curDis = nextDist[1];
                }
            }
        }

        return new int[]{curNode, curDis};
    }
}
