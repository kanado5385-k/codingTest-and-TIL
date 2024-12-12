import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS2178 {
    static int result;
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
        public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
               map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(result);

        sc.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poolValue = queue.poll();
            int currentX = poolValue[0];
            int currentY = poolValue[1];
            int currentDistance = poolValue[2];

            if (currentX == N - 1 && currentY == M - 1) {
                result = currentDistance;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + currentX;
                int ny = dy[k] + currentY;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (visited[nx][ny] == false && map[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny, currentDistance + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
