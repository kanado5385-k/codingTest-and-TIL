import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TwoPointer30804 {
    public static void main (String[] args) {
        List<Integer> arr;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        if (isTwoTypeHere(arr)){
            System.out.println(arr.size());
        }
        else {
            int left = 0;
            int right = arr.size() -1;

            while (arr.size() > 2) {
                boolean isTwoType;
                isTwoType = isTwoTypeHere(arr);
                if (isTwoType) {
                    break;
                }
                arr.remove(left);
                right = arr.size() -1;

                isTwoType = isTwoTypeHere(arr);
                if (isTwoType) {
                    break;
                }
                arr.remove(right);
            }

            System.out.println(arr.size());
        }
        sc.close();
      }

      static boolean isTwoTypeHere(List<Integer> arr) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }

        int uniqueColors = uniqueSet.size();
        if (uniqueColors <= 2){
            return true;
        }
        return false;
      }
}
