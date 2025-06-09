import java.util.*;

public class s13335 {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in); 
    int n = sc.nextInt();
    int m = sc.nextInt();
    int L = sc.nextInt();
    Queue<Integer> truck = new LinkedList<Integer>();
    Queue<Integer> bridge = new LinkedList<Integer>();

    for (int i = 0; i < n; i++) {
        truck.add(sc.nextInt());
    }

    int result = 0;
    int weight = 0;

    for (int i = 0; i < m; i++) {
        bridge.add(0);
    }

    while (!bridge.isEmpty()) {
        result++;
        weight -= bridge.poll();
        if (!truck.isEmpty()) {
            if ((truck.peek() + weight) <= L) {
                bridge.add(truck.peek());
                weight = weight + truck.poll();
            }
            else {
                bridge.add(0);
            }
        }
    }

    System.out.println(result);
    sc.close();
}
}

// O(m+n)
