package gold.dp;

import java.util.Scanner;

public class baekjoon12865 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[][] dp = new int[N + 1][K + 1];
    int[] w = new int[N + 1];
    int[] v = new int[N + 1];

    for (int i = 1; i < N+1; i++) {
        w[i] = sc.nextInt();
        v[i] = sc.nextInt();
    }

    for (int i = 1; i <= N; i++) {
        for (int weight = 0; weight <= K; weight++) {
            if (w[i] <= weight) {
                dp[i][weight] = Math.max(dp[i-1][weight], dp[i - 1][weight - w[i]] + v[i]);
            } else {
                dp[i][weight] = dp[i - 1][weight];
            }
        }
    }

    System.out.println(dp[N][K]);

    }
}
