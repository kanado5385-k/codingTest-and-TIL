import java.util.Arrays;
import java.util.Scanner;

public class Scheduling1931 {
    public static void main (String[] args) {
        int[][] time;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, (s1, s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            }
            return s1[1] - s2[1];
        });

        int endTime = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            if(endTime <= time[i][0]) {
                endTime = time[i][1];
                result ++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}