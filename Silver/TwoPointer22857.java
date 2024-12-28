import java.util.Scanner;

public class TwoPointer22857 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;

        int N = sc.nextInt();
        int K = sc.nextInt();

        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int oddCount = 0;
        int result = 0;

        while (right < N) {
            if (arr[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > K) {
                if (arr[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            result = Math.max(result, right - left + 1 - oddCount);
            right++;
        }

        System.out.println(result);
        sc.close();
    }
}
