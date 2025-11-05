package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b11497 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Deque<Integer> dq = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 1; i <= arr.length; i++) {
                if (i % 2 != 0) {
                    dq.addFirst(arr[i-1]);
                } else {
                    dq.addLast(arr[i-1]);
                }
            }

            int curMin = dq.getLast() - dq.getFirst();
            int min = Math.abs(curMin);

            for (int i = 0; i < N - 1; i++) {
                int curNum = dq.removeFirst();
                int curMin1 = curNum - dq.getFirst();
                curMin1 = Math.abs(curMin1);
                if (curMin1 > min) {
                    min = curMin1;
                }
            }

            sb.append(min).append("\n");

        }

        System.out.println(sb.toString());
    }
}
