package d3;


import java.util.Scanner;

public class Flatten1208 {
    public static void main(String args[]) throws Exception {  

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] arr = new int[100]; // 고정된 크기의 배열 사용
            int domp = sc.nextInt();

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }

            while (domp > 0) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int indexOfMax = 0;
                int indexOfMin = 0;

                // 최대값 및 최소값, 인덱스 찾기
                for (int i = 0; i < 100; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        indexOfMax = i;
                    }
                    if (arr[i] < min) {
                        min = arr[i];
                        indexOfMin = i;
                    }
                }

                // 평탄화 완료 조건
                if (max - min <= 1) {
                    break;
                }

                // 덤프 작업
                arr[indexOfMax] -= 1;
                arr[indexOfMin] += 1;
                domp--;
            }

            // 최종 결과 계산
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 100; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            int result = max - min;
            System.out.println("#" + test_case + " " + result);
        }

        sc.close();
    }
}
