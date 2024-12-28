import java.util.Scanner;

public class Dp9095 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] dp;

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            dp = new int[n + 1];
            dp[1] = 1;
            if (n >= 2) {
                dp[2] = 2;
            }
            if (n >= 3) {
                dp[3] = 4;
            }
            if (n > 3) {
                for (int i = 4; i < n+1; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
