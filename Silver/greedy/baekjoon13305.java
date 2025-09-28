package greedy;

import java.util.Scanner;

public class baekjoon13305 {
        public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] distanse = new int[N - 1];
        int[] price = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            distanse[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }

        int totalPrice = price[0] * distanse[0];
        int curPrice = price[0];

        for (int i = 1; i < N - 1; i++) {
            if (price[i] < curPrice) {
                curPrice = price[i];
            }

            totalPrice += curPrice * distanse[i];
        }

        System.out.println(totalPrice);

    }
}
