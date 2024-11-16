import java.util.Scanner;

public class DFS1743 {
    static int result = Integer.MIN_VALUE;
    static int sumOfGarb;
    static int h;
    static int w;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0 , 0 , 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        int garb = sc.nextInt();

        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < garb ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
    
            map[x-1][y-1] = 1;
        }

        //System.out.println(map[2][0]);


        for (int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if (visited[i][j] == false && map[i][j] == 1) {
                    sumOfGarb = 1;
                    dfs(i,j);
                    result = Math.max(sumOfGarb, result);
                }
            }
        }

        System.out.println(result);
        sc.close();
    }

    static void dfs(int x, int y) {

        visited[x][y] = true;
        for (int k = 0 ; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (visited[nx][ny] == false && map[nx][ny] == 1) {
                    sumOfGarb++;
                    //System.out.println(sumOfGarb);
                    dfs(nx, ny);
                }
            }
        }
    }
}
