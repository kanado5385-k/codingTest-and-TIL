import java.util.Scanner;

public class Dp1932 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        int[][] dp;

        int N = sc.nextInt();

        arr = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i-1][j-1] + arr[i][j]);
                } 
            }
        }

        int maxNum = Integer.MIN_VALUE;
        for(int num: dp[N - 1]){
            if (num > maxNum) {
                maxNum = num;
            }
        }

        System.out.println(maxNum);
        sc.close();
    }
}
