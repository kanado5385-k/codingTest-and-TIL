import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS최단겅로2178 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = Integer.MAX_VALUE;
        int[][] map;
        boolean[][] visited;
        int[] dx ={0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curX = node[0];
            int curY = node[1];
            int curDis = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        int dis = curDis + 1;
                        if (nx == N - 1 && ny == M -1) {
                            if (dis < result) {
                                result = dis;
                            }
                        }
                        queue.offer(new int[]{nx, ny, dis});
                    }
                }
            }

        }

        System.out.println(result);
        sc.close();
    }
}
