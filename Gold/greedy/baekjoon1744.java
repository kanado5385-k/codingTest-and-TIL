package gold.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(arr[0]);
        }
        else {
                    Arrays.sort(arr);
        int sum = 0;

        int currentIndex = 0;
        while (true) {
            if (arr[currentIndex] < 0) {
                if (arr[currentIndex + 1] <= 0) {
                    sum += (arr[currentIndex] * arr[currentIndex + 1]);
                    currentIndex += 2;
                    if (currentIndex > N - 1) {
                        break;
                    }
                    if (currentIndex + 1 > N - 1) {
                        sum += arr[currentIndex];
                    }
                    continue;
                }
                if (arr[currentIndex + 1] > 0) {
                    sum += arr[currentIndex];
                    break;
                }
            }
            if (arr[currentIndex] >= 0) {
                break;
            }
        }

        currentIndex = N - 1;
        while (true) {
            if (arr[currentIndex - 1] > 0) {
                if (arr[currentIndex] == 1 || arr[currentIndex - 1] == 1){
                    sum += (arr[currentIndex] + arr[currentIndex - 1]);
                    currentIndex -= 2;
                    if (currentIndex < 0) {
                        break;
                    }
                    if (currentIndex - 1 < 0) {
                        sum += arr[currentIndex];
                        break;
                    }
                    continue;
                }
                sum += (arr[currentIndex] * arr[currentIndex - 1]);
                currentIndex -= 2;
                if (currentIndex < 0 || currentIndex - 1 < 0) {
                        break;
                    }
                continue;
            }
            if (arr[currentIndex - 1] == 0) {
                sum += arr[currentIndex];
                break;
            }
            if (arr[currentIndex - 1] < 0) {
                sum += arr[currentIndex];
                break;
            }
        }

        System.out.println(sum);
        }
    }
}
