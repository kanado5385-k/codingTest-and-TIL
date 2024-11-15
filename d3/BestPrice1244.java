package d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestPrice1244 {
	    private static int maxValue;  // 최대값 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        for (int test_case = 1; test_case <= T; test_case++) {
            String readLine = sc.nextLine();
            String[] splitLine = readLine.split(" ");
            String splittedNumbers = splitLine[0];
            int splittedTryNum = Integer.parseInt(splitLine[1]);

            List<Integer> intNumbers = new ArrayList<>();
            for (int i = 0; i < splittedNumbers.length(); i++) {
                intNumbers.add(Character.getNumericValue(splittedNumbers.charAt(i)));
            }

            maxValue = 0;  // 새로운 테스트 케이스마다 초기화
            dfs(intNumbers, splittedTryNum);

            System.out.println("#" + test_case + " " + maxValue);
        }

        sc.close();
    }

    private static void dfs(List<Integer> numbers, int swapsLeft) {
        if (swapsLeft == 0) {
            int currentValue = calculateValue(numbers);
            maxValue = Math.max(maxValue, currentValue);
            return;
        }

        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(numbers, i, j);  // 두 자리 교환
                dfs(numbers, swapsLeft - 1);  // 교환 횟수 감소 후 DFS
                swap(numbers, i, j);  // 백트래킹: 원상 복구
            }
        }
    }

    private static int calculateValue(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num);
        }
        return Integer.parseInt(sb.toString());
    }

    private static void swap(List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
