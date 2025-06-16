import java.util.*;
import java.util.Scanner;

public class s1431 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextLine());
        }

        list.sort((o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    
                    if (num1 > 0 && num1 < 10) {
                        a += num1;
                    }

                    if (num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }
                if (a == b) {
                    return o1.compareToIgnoreCase(o2);
                }
            return a-b;
            }
        });

        list.forEach(System.out::println);
        sc.close();
    }

    // 시간복잡도 = O(NlogN)
}
