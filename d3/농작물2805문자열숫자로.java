package d3;

import java.util.Scanner;

public class 농작물2805문자열숫자로 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 첫 번째 개행 제거

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            sc.nextLine(); // 개행 제거

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = sc.nextLine(); // 한 줄을 문자열로 읽음
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0'; // 각 문자를 숫자로 변환하여 저장
                }
            }

            int result = 0;
            int mid = N / 2;

            
            for (int i = 0; i <= mid; i++) {
                for (int j = mid - i; j <= mid + i; j++) {
                    result += map[i][j];
                }
            }

            // 아래쪽
            for (int i = mid + 1; i < N; i++) {
                for (int j = i - mid; j < N - (i - mid); j++) {
                    result += map[i][j];
                }
            }

            System.out.printf("#%d %d%n", test_case, result);
        }

        sc.close();
    }
}
