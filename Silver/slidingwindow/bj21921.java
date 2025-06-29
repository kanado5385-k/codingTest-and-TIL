package slidingwindow;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class bj21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = X - 1;
        int max = 0;
        int days = 0;
 
        for (int i = 0; i <= end; i++) {
            max += arr[i];
        }

        if (max > 0) {
            days++;
        }

        int sum = max;
        while (end < N - 1) {
            sum -= arr[start];
            start++;

            end++;
            sum += arr[end];

            if (sum == max) {
                days++;
            } else if (sum > max) {
                days = 1;
                max = sum;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(days);
        }
    }
}
