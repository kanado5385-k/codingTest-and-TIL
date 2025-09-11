package DFS;

import java.util.Scanner;

public class baekjoon4963 {
    static int h;
    static int w;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if ( w == 0 || h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i<h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for (int i = 0; i<h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visited[i][j] == false && map[i][j] == 1) {
                        dfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                    dfs(nx,ny);
                }
            }
        }
    }
}
