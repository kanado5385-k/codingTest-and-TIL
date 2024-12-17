import java.util.Scanner;

public class TwoPointer2559 {
    public static void main (String[] args) {
        int resul = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        int[] arr;

        int N = sc.nextInt();
        int K = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = left + K - 1;

        while (right < N) {
            int total = 0;
            for (int i = left; i <= right; i++) {
                total += arr[i];
            }

            left ++;
            right = left + K - 1;

            if (total > resul) {
                resul = total;
            }
        }

        System.out.println(resul);
        sc.close();

    }
}
