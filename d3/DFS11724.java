package d3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS11724 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int result = 0;
    static boolean[] visited;
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++){
            if (visited[i] == false){
                result++;
                dfs(i);
            }
        }

        System.out.println(result);
        sc.close();
    }

    static void dfs(int node){
        visited[node] = true;

        for(int childNode : graph.get(node)){
            if (visited[childNode] == false){
                dfs(childNode);
            }
        }
    }
}
