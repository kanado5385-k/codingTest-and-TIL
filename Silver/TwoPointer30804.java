import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoPointer30804 {
    public static void main (String[] args) {
        int result = 0;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }

        int uniqueColors = uniqueSet.size();
        result = arr.length;

        if (uniqueColors > 2) {
            int left = 0;
            int right = arr.length -1;

            while (uniqueColors > 2) {
                int rightNum = arr[right];
                int leftNum = arr[left];

                if (rightNum == leftNum) {
                    result -= 2;

                    right--;
                    left++;

                }
            }
        }

        System.out.println(result);
        sc.close();
      }
}
