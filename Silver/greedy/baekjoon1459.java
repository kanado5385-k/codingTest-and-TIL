package greedy;

import java.util.Scanner;

public class baekjoon1459 {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();
    int Y = sc.nextInt();

    int oneBlack = sc.nextInt();
    int diagonal = sc.nextInt();

    int result = 0;

    for (int i = 0; i < Y; i++) {
        if((oneBlack*2) < diagonal) {
            result += oneBlack*2;
        } else {
            result += diagonal;
        }
    }

    int remainedX = X - Y;
    for (int i = 1; i <= remainedX; i++) {
        result+=oneBlack;
    }

    System.out.println(result);
    sc.close();
    }
}
