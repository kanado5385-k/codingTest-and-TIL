package queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class b11286 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                    continue;
                } else {
                    int[] cur = queue.poll();
                    System.out.println(cur[0]);
                    continue;
                }
            } else {
                int abs = Math.abs(n);
                queue.add(new int[]{n, abs});
            }
        }
    }
}
