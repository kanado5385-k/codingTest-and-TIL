import java.util.Scanner;

public class Dp문제1463 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp;
        int N = sc.nextInt();

        dp = new int[N + 1];

        if(N > 1) {
            dp[2] = 1;
        }
        if(N > 2) {
            dp[3] = 1;
        }
        if(N > 3) {
            for (int i = 4; i < N + 1; i++) {
                if (i%6 == 0) {
                    dp[i] = Math.min(dp[i/2], Math.min(dp[i/3], dp[i-1])) + 1;
                }
                else if (i%2 == 0) {
                    dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
                }
                else if (i%3==0) {
                    dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
                }
                else {
                    dp[i] = dp[i-1] + 1;
                }
            }
        }

        System.out.print(dp[N]);
        sc.close();
    }
}
