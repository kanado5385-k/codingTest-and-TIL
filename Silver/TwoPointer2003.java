import java.util.Scanner;

public class TwoPointer2003 {
    public static void main (String[] args) {
        int result = 0;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N + 1];

        int left = 0;
        int right = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        while (right < N + 1) {
            if (sum < M) {
                sum += arr[right++];
            } else if (sum > M) {
                sum -= arr[left++];
            } else {
                result++;
                sum -= arr[left++];
            }
        }

        System.out.println(result);
        sc.close();
    }
}
