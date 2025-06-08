import java.util.*;

public class s11866 {
       public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            for (int k = 1; k < K; k++) {
                q.add(q.poll());
            }
            if(q.size() == 1) {
                sb.append(q.poll()).append(">");
            } else {
                sb.append(q.poll()).append(", ");
            }
        }

        System.out.println(sb.toString());
        sc.close();
       } 
}

// O(NlogN)
