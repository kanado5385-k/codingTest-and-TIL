package d3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS2644 {
    static int result = -1;
    static List<List<Integer>> familyGraf = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int start = sc.nextInt();
        int target = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n + 1; i++) {
            familyGraf.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            familyGraf.get(a).add(b);
            familyGraf.get(b).add(a);
        }

        visited = new boolean[n + 1];
        int depth = 0;

        dfs(start, target, depth);

        System.out.println(result);
        sc.close();
    }

    public static void dfs(int curent, int target, int depth) {
        if (curent == target) {
            result = depth;
            return;
        }

        visited[curent] = true;

        for (int child : familyGraf.get(curent)) {
            if (visited[child] == false) {
                dfs(child, target, depth + 1);
            }
        }
    }


}
