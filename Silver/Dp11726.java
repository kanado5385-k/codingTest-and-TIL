import java.util.Scanner;

public class Dp11726 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp;

        int N = sc.nextInt();

        dp = new long[N+1];

        dp[1] = 1;
        if (N >= 2){
            dp[2] = 2;
            for (int i = 3; i < N + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
