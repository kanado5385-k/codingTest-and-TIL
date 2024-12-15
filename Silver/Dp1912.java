import java.util.Scanner;

public class Dp1912 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] dp;
        int[] numbers;

        int N = sc.nextInt();

        dp = new Integer[N];
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        dp[0] = numbers[0];
        int maxNum = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);

            maxNum = Math.max(dp[i], maxNum);
        }

        System.out.println(maxNum);
        sc.close();

    }
}
