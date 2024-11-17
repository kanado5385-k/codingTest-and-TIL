package d3;
import java.util.Scanner;

public class DFS4963방향8 {
    static int w;
    static int h;
    static int result = 0;
    static boolean[][] visited;
    static int[][] map; 

    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            result = 0;
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }


            for (int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if (visited[i][j] == false && map[i][j] == 1) {
                        dfs(i,j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
        sc.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
    
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
    
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
