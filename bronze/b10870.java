package bronze;

import java.util.Scanner;

public class b10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr;
        int n;
        n = sc.nextInt();

        arr = new int[n+1];

        if (n >= 2) {
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i < n+1; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        else if (n == 0) {
            arr[0] = 0;
        }
        else {
            arr[1] = 1;
        }
        System.out.println(arr[n]);
        sc.close();
    }
}
