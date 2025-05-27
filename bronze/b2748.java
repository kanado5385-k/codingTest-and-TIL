package bronze;

import java.util.Scanner;

public class b2748 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long arr[];
        int n = s.nextInt();

        arr = new long[92];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
        s.close();
    }
}

//O(n)