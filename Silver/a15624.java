import java.util.Scanner;

public class a15624 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] DP = new long[1000001];
        DP[1] = 1;
        for(int i = 2; i < n+1; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        
        long sum = DP[n] % 1000000007;

        System.out.print(sum);
    }
}
