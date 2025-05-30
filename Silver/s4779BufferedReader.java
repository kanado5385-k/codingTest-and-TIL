import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class s4779BufferedReader {
    static StringBuilder sb;
    public static void main (String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        int N;

        while ((str = br.readLine()) != null ){
            sb = new StringBuilder();
            N = Integer.parseInt(str);
            int K = 1;
            if (N > 0) {
                for (int i = 1; i <= N; i++) {
                    K = K * 3;
                }
            }

            for (int i = 0; i < K; i++) {
                sb.append("-");
            }

            getKantooSet(0, K);
            System.out.println(sb.toString());
        }
        s.close();
    }

    static void getKantooSet (int start, int K) {
        if (K % 3 != 0) {
            return;
        }

        int kangeak = K / 3;

        for (int i = start + kangeak; i < kangeak * 2 + start; i++) {
            sb.setCharAt(i, ' ');
        }

        getKantooSet(start, kangeak);
        getKantooSet(start+kangeak*2, kangeak);
    }
}

// 시간복잡도 = O(3^N)