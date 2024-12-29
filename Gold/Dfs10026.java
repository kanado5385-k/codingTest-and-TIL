package gold;
import java.util.Scanner;

public class Dfs10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int red = 0;
        int blue = 0;
        int green = 0;
        int redAndGreen = 0;

        N = sc.nextInt();
        sc.nextLine();

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'R' && visited[i][j] == false) {
                    red++;
                    dfsForOneColor(i,j,'R');
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'B' && visited[i][j] == false) {
                    blue++;
                    dfsForOneColor(i,j,'B');
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G' && visited[i][j] == false) {
                    green++;
                    dfsForOneColor(i,j,'G');
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if((map[i][j] == 'R' || map[i][j] == 'G') && visited[i][j] == false) {
                    redAndGreen++;
                    dfsForTwoColor(i,j,'R', 'G');
                }
            }
        }

        int human = red + blue + green;
        int cow = redAndGreen + blue;
        System.out.print(human + " ");
        System.out.println(cow);
        sc.close();
    }

    static void dfsForOneColor(int x, int y, char color) {
        visited[x][y] =  true;

        for (int i =0 ; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N &&  ny < N) {
                if(map[nx][ny] == color && visited[nx][ny] == false) {
                    dfsForOneColor(nx,ny,color);
                }
            }
        }

    }

    static void dfsForTwoColor(int x, int y, char color1, char color2) {
        visited[x][y] =  true;

        for (int i =0 ; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N &&  ny < N) {
                if((map[nx][ny] == color1 || map[nx][ny] == color2) && visited[nx][ny] == false) {
                    dfsForTwoColor(nx,ny,color1, color2);
                }
            }
        }

    }
}
