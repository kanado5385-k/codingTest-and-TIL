package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<int []> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cut = queue.poll();
            int x = cut[0];
            int y = cut[1];

            if (x == N - 1 && y == M -1) {
                return map[x][y];
            }

            for (int k = 0; k < 4; k ++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return -1;
        
    }
}
