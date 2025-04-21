package bronze;

import java.io.IOException;
import java.util.Scanner;

public class b2738 {
        public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N, M;
        int[][] arr1;
        int[][] arr2;
        N = sc.nextInt();
        M = sc.nextInt();

        arr1 = new int[N][M];
        arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();     
    }
}
