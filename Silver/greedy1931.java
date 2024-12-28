import java.util.Arrays;
import java.util.Scanner;

public class greedy1931 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        int result = 0;
        int endTime = 0;

        int N = sc.nextInt();

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, (s1,s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            }
            return s1[1] - s2[1];
        });

        for (int i = 0; i < N; i++) {
            if(arr[i][0] >= endTime) {
                endTime = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
