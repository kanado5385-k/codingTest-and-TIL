import java.util.Scanner;

public class Dp2193 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp;

        int N = sc.nextInt();
        dp = new long[N + 1];

        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 1;
        }
        if (N >= 3) {
            for (int i = 3; i < N+1; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
