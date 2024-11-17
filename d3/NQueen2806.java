package d3;

import java.util.Scanner;

public class NQueen2806 {
    static int result;
    static int N;
    static boolean[] col;       // 열 체크
    static boolean[] diag1;     // 대각선1 체크 (row - col)
    static boolean[] diag2;     // 대각선2 체크 (row + col)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            result = 0;

            col = new boolean[N];
            diag1 = new boolean[2 * N - 1];
            diag2 = new boolean[2 * N - 1];

            //diag1 = new boolean[N + M - 1];  // row - col의 범위: -(N - 1) ~ (M - 1)
            //diag2 = new boolean[N + M - 1];  // row + col의 범위: 0 ~ (N + M - 2)

            dfs(0);  // 첫 번째 행부터 시작
            System.out.println("#" + test_case + " " + result);
        }

        sc.close();
    }

    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row - c + N - 1] || diag2[row + c]) {
                continue;  // 열이나 대각선이 이미 사용 중이면 스킵
            }

            col[c] = true;
            diag1[row - c + N - 1] = true;
            diag2[row + c] = true;

            //col[c] = true;
            //diag1[row - c + (N - 1)] = true;  // 음수를 방지하기 위해 (N - 1) 더함
            //diag2[row + c] = true;

            dfs(row + 1);  // 다음 행으로 이동

            // 백트래킹: 상태 복구
            col[c] = false;
            diag1[row - c + N - 1] = false;
            diag2[row + c] = false;
        }
    }
}
