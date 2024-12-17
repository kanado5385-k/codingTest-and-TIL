package gold;

import java.util.Scanner;

public class DFS16929사이클 {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static String result = "NO";

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, map[i][j])) {
                        result = "YES";
                        System.out.println(result);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
        sc.close();
    }

    static boolean dfs(int x, int y, int px, int py, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == color) {
                    if (!visited[nx][ny]) {
                        if (dfs(nx, ny, x, y, color)) {
                            return true;
                        }
                    } else if (!(nx == px && ny == py)) {
                        // 직전 노드가 아니라면 사이클 발견
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
