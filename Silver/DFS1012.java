import java.util.Scanner;

public class DFS1012 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int snake = 0;
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();

            int K = sc.nextInt();

            arr = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[b][a] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visited[i][j] == false && arr[i][j] == 1) {
                        snake++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(snake + "\n");
            snake = 0;
        }

        System.out.println(sb.toString());
        sc.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visited[nx][ny] == false && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
