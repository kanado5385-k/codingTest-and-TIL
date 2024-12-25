import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer7795 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] arrA;
        int[] arrB;

        int T = sc.nextInt();
        for (int t =0; t < T; t++) {
            int result = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();

            arrA = new int[N];
            arrB = new int[M];

            for (int i = 0; i < N; i++) {
                arrA[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                arrB[i] = sc.nextInt();
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);


            int pointerB = 0;


            for ( int pointerA = 0; pointerA < N; pointerA++) {
                while (pointerB < M && arrA[pointerA] > arrB[pointerB]) {
                    pointerB++;
                }
                result += pointerB;
            }

            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
