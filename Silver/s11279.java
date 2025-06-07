import java.util.*;

public class s11279 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        StringBuilder sb = new StringBuilder(); 

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == 0) {
                if (pq.peek() == 0) {
                    sb.append(pq.peek()).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
                continue;
            }
            pq.add(n);
        }

        System.out.println(sb.toString());
        sc.close();
    }
}

// O(N)
