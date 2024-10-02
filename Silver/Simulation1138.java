import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Simulation1138 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            function1(list, result, i);
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void function1(List<Integer> list, List<Integer> result, int i) {
        int num = list.get(i);
        result.add(num, list.size()-i);
    }
}
