package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon18111 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int B = sc.nextInt();

        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int h = min; h <= max + B; h++) {
            int remove = 0, add = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > h) {
                        remove += map[i][j] - h;
                    } else {
                        add += h - map[i][j];
                    }
                }
            }
            if (remove + B >= add) {
                int time = remove * 2 + add;
                if (time < resultTime || (time == resultTime && h > resultHeight)) {
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
        sc.close();
    }
}
