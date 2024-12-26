import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sim10773 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        List<Integer> list = new ArrayList<>();

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                list.remove(list.size() - 1);
            }
            else {
                list.add(num);
            }
        }

        for (int num: list) {
            result += num;
        }

        System.out.println(result);
        sc.close();
    }
}
