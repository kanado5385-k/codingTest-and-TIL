package d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최빈수1204 {
    	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            List<Integer> arr = new ArrayList<>();
            int currT = sc.nextInt(); 
            int maxSum = 0;
            int count = 0;
            int result = 0;

            for (int i = 0; i < 1000 ; i++) {
                arr.add(sc.nextInt());
            }

            for (int i = 0; i < 101 ; i++) {
                count = 0;
                if(arr.contains(i)){
                    for (int j = 0; j < 1000 ; j++) {
                        if (arr.get(j) == i){
                            count ++;
                        }
                    }
                    if (count > maxSum) {
                        result = i;
                        maxSum = count;
                    }
                    if (maxSum == count) {
                        result = result > i ? result : i;
                    }
                }
            }

            System.out.println("#" + currT + " " + result);

		}
        sc.close();
	}
}
