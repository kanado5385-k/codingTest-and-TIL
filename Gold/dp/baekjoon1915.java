package gold.dp;

import java.util.Scanner;

public class baekjoon1915 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;

        int[][] board = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
                dp[i][j] = line.charAt(j) - '0';

                if (dp[i][j] == 1) {
                max = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i - 1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max*max);
    }
}
