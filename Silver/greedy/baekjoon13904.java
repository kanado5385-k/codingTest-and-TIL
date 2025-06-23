package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon13904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Homework[] arr = new Homework[n];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            arr[i] = new Homework(d, s);
            if (d > maxDeadline) maxDeadline = d;
        }


        Arrays.sort(arr, (a, b) -> b.day - a.day);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0, idx = 0;

        for (int day = maxDeadline; day > 0; day--) {
            while (idx < n && arr[idx].day >= day) {
                q.offer(arr[idx].score);
                idx++;
            }
            if (!q.isEmpty()) {
                sum += q.poll();
            }
        }

        System.out.println(sum);
    }

    static class Homework {
        int day, score;

        Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}
