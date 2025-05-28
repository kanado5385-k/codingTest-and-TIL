import java.util.Scanner;

public class S42345 {
        public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[];
        int N = s.nextInt();
        int K = s.nextInt();

        arr = new int[N+1];
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        int result = findEratostenesNumber(arr, N, K);
        System.out.println(result);
        s.close();

    }

    private static int findEratostenesNumber(int[] arr1, int n, int k) {
        for (int i = 2; i <= n; i++) {
            if (arr1[i] == 0) {
                continue;
            }
            for (int j = i; j <= n; j += i) {
                if (arr1[j] != 0) {
                    arr1[j] = 0;
                    k--;
                    if (k == 0) {
                     return j;
                     }
                }
            }
        }
        return 2;
    }
}

//O(N로그N)