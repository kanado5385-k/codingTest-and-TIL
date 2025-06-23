package greedy;

import java.util.Scanner;

public class baekjoon2512 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int left = 0;
        int right = -1;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        int M = sc.nextInt();

        while (left <= right) {
            int candidateUpLimit = (left + right) / 2;
            int budget = 0;
            for (int i = 0; i < N; i++) {
                budget += Math.min(candidateUpLimit, arr[i]);
            }

            if (budget <= M) {
                left = candidateUpLimit + 1;
            }
            else {
                right = candidateUpLimit - 1;
            }
            
        }

        System.out.println(right);

    } 
}
