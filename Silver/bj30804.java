import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;

public class bj30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        Map<Integer, Integer> map = new HashMap<>();
        while (end < N) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[start], map.getOrDefault(arr[start], 1) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            max = Math.max(end - start + 1, max);
            end++;
        }

        System.out.println(max);

    }
}

// 시간복잡도 = O(N)