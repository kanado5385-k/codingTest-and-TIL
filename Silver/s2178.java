import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s2178 {
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        int result = bfs(0, 0);

        System.out.println(result);
        sc.close();
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y, 1));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if(now.x == N - 1 && now.y == M - 1) {
                return now.dist;
            }

        for (int k =0; k < 4; k++) {
            int nx = now.x + dx[k];
            int ny = now.y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visited[nx][ny] == false && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, now.dist + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Point {
        int x;
        int y;
        int dist;

        Point(int x,int y,int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
