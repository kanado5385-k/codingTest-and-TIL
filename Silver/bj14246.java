import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14246 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;

        int sum = 0;
        int result = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum > k) {
                result += n - end;
                sum -= arr[start];
                start++;
            }
            end++;
        }

        System.out.println(result);
    }
}

// 시간복잡도 = O(N)
