import java.util.Scanner;

public class s2559 {
    public static void main(String[] args){  
        Scanner s = new Scanner(System.in);
        int N;
        int K;

        int arr[];

        N = s.nextInt();
        K = s.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        int result = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = i; j < i + K; j++) {
                temp += arr[j];
            }
            if (temp > result) {
                result = temp;
            }

            if(i + K == N) {
                break;
            }
        }

        System.out.println(result);
        s.close();
    }
}

// O(N제곱)