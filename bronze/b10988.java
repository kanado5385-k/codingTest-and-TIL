package bronze;

import java.util.Scanner;

public class b10988 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int length = word.length();
        int result = 1;

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
