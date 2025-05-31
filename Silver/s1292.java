import java.util.Scanner;

public class s1292 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        int start = s.nextInt();
        int end = s.nextInt();

        int arr[] = new int[1000];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i && index < arr.length; j++) {
                arr[index++] = i;
            }
        }

        int result = 0;
        for (int j = start - 1; j <= end - 1; j++) {
            result += arr[j];
        }

        System.out.println(result);
        s.close();
    }
}

// O(1)
