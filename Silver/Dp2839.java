import java.util.Scanner;

public class Dp2839 {
    public static void main(String[] args) {
        int[] dp;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = 5000;
        }

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i < N + 1; i++) {
            dp[i] = Math.min(dp[i -3], dp[i - 5]) + 1;
        }

        if (dp[N] >= 5000){
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }

        sc.close();
    }
}
