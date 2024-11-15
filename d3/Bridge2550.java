package d3;

import java.util.Scanner;

public class Bridge2550 {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= T; i ++) {
            int resultOfOneRound = startOneRound(sc);
            System.out.printf("#%d", i);
            System.out.println(" " + resultOfOneRound);
        }

        sc.close();
    }

    private static int startOneRound(Scanner sc) {
        char[] bridge = sc.nextLine().toCharArray();
        String kAndM = sc.nextLine();
    
        String[] stringKAndM = kAndM.split(" ");
        int K = Integer.parseInt(stringKAndM[0]);
        int M = Integer.parseInt(stringKAndM[1]);
    
        int countOfSing = 0;
        int currentLocation = 0;
    
        while (currentLocation < bridge.length - 1) {
            if (bridge[currentLocation + 1] == '0') {
                if (currentLocation + K >= bridge.length) {
                    return -1;
                }
                countOfSing++;
                for (int i = 1; i <= K; i++) {
                    bridge[currentLocation + i] = '1';
                }
            }
            currentLocation++;
        }
        return countOfSing;
    }
}
