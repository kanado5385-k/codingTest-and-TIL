import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer3273 {
        public static void main (String[] args) {
        int result = 0;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int curNum = arr[left] + arr[right];

            if(curNum == x) {
                result++;
                left++;
                right--;
            }

            else if(curNum < x) {
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