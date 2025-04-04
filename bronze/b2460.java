package bronze;

import java.io.IOException;
import java.util.Scanner;

public class b2460 {
    	public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            int[][] train = new int[10][2];

            for(int i = 0; i < 10; i++) {
                train[i][0] = s.nextInt();
                train[i][1] = s.nextInt();
            }

            int max = 0;
            int curNum = 0;
            for(int i = 0; i < 10; i++) {
                curNum -= train[i][0];
                curNum += train[i][1];
                if ( curNum > max) {
                    max = curNum;
                }
            }

            System.out.println(max);
            s.close();
        }
        
    }