package bronze;

import java.io.IOException;
import java.util.Scanner;

public class b1292 {
        	public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            int A, B;
            int[] arr;
            A = s.nextInt();
            B = s.nextInt();

            arr = new int[B+1];

            for (int i = 1; i <= B; i++) {
                for (int j = 1; j <= i; j++) {
                    arr[i] = i;
                }
            }

            int result = 0;
            for (int i = A; i <= B; i++) {
                result += arr[i];
            }

            System.out.println(result);
        }
}
