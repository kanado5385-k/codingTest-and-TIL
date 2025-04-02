package bronze;

import java.io.IOException;
import java.util.Scanner;

public class b3460 {
    	public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            int T;
            int N;
            T = s.nextInt();
            for (int i =0; i < T; i++) {
                N = s.nextInt();
                String binary = Integer.toBinaryString(N);
                for (int j = 0; j < binary.length(); j++){
                    if (binary.charAt(j) == '1') {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }
        }

}
