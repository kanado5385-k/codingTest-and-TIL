import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer1940 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int result = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int leftNum = arr[left];
            int rightNum = arr[right];

            int sum = leftNum + rightNum;
            if (sum == M) {
                result++;
                left++;
                right--;
            }
            else if (sum < M) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
