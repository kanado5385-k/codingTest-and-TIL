import java.util.Scanner;

public class DP1463 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp;

        int N = sc.nextInt();

        dp = new int[10000000];

        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i/2], dp[i/3]), dp[i-1]) + 1;
                continue;
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
                continue;
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
                continue;
            }

            dp[i] = dp[i-1] + 1; 
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
