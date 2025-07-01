package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1182 {
    static int S;
    static int N;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i< N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if(S == 0) result--;

        System.out.println(result);
    }

    private static void dfs(int num, int sum) {
        if (num == N) {
            if (sum == S) {
                result++;
            }
            return;
        }

        dfs(num + 1, sum + arr[num]);
        dfs(num + 1, sum);
    }
}

// 시간복잡도: O(2^N)
