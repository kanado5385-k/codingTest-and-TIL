package slidingwindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class b21921 {
    public static void main(String[] args) throws IOException { 
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int max = 0;
        int dayCount = 1;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {
            max = max + arr[i];
        }

        int left = 0;
        int sum = max;
        for (int i = K; i < N; i++) {
            sum -= arr[left];
            sum += arr[i];
            if (sum > max) {
                max = sum;
                dayCount = 1;
            } else if (sum == max) {
                dayCount++;
            }

            left++;
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(dayCount);
        }
    }
}
