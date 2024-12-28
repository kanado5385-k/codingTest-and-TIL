import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer28353 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;

        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int right = arr.length - 1;
        int left = 0;
        int result = 0;

        while (left < right) {
            int weight = arr[left] + arr[right];
            if (weight > K) {
                right--;
            }
            else {
                left++;
                right--;
                result++;
            }
        }

        System.out.println(result);
        sc.close();

    }

}
