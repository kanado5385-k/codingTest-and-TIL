import java.util.Scanner;

public class dpProblem2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp;
        int[] stair;

        int n = sc.nextInt();

        dp = new int[n + 1];
        stair = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1];
        dp[2] = stair[2] + stair[1];

        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
        }

        System.out.println(dp[n]);
        sc.close();
    }
}
