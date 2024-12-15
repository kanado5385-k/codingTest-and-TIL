import java.util.Scanner;

public class DP2579 {
    public static void main (String[] args) {
        int[] num;
        int[] dp; 
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        num = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            num[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println(num[1]);
            sc.close();
            return;
        }

        if (N == 2) {
            System.out.println(num[1] + num[2]);
            sc.close();
            return;
        }

        dp[1] = num[1];
        dp[2] = num[1] + num[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i-1] + num[i]);
        }

        System.out.println(dp[N]);

        sc.close();
    }
}
