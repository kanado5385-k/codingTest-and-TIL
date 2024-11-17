package d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilityMethods {
    
    // 1. 문자열을 숫자 리스트로 변환
    public static List<Integer> stringToNumberList(String str) {
        List<Integer> numberList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            numberList.add(Character.getNumericValue(ch));
        }
        return numberList;
    }

    // 2. 숫자 리스트를 문자열로 변환
    public static String numberListToString(List<Integer> numberList) {
        StringBuilder result = new StringBuilder();
        for (int num : numberList) {
            result.append(num);
        }
        return result.toString();
    }

    // 3. 두 숫자를 붙여서 새로운 숫자(int)로 변환
    public static int concatenateNumbersAsInt(int num1, int num2) {
        String combinedString = String.valueOf(num1) + String.valueOf(num2);
        return Integer.parseInt(combinedString);
    }

    // 3. 두 숫자를 붙여서 새로운 숫자(long)로 변환
    public static long concatenateNumbersAsLong(long num1, long num2) {
        String combinedString = String.valueOf(num1) + String.valueOf(num2);
        return Long.parseLong(combinedString);
    }

    // 4. 리스트에서 최소값 찾기
    public static int findMin(List<Integer> numbers) {
        return Collections.min(numbers);
    }

    // 4. 리스트에서 최대값 찾기
    public static int findMax(List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static void main(String[] args) {
        // 테스트 1: 문자열을 숫자 리스트로 변환
        String str = "2343";
        List<Integer> numberList = stringToNumberList(str);
        System.out.println("Number List from String: " + numberList);

        // 테스트 2: 숫자 리스트를 문자열로 변환
        List<Integer> list = Arrays.asList(1, 2, 3);
        String concatenatedString = numberListToString(list);
        System.out.println("String from Number List: " + concatenatedString);

        // 테스트 3: 두 숫자를 붙이기
        int resultInt = concatenateNumbersAsInt(123, 1);
        System.out.println("Concatenated as int: " + resultInt);

        long resultLong = concatenateNumbersAsLong(123456789L, 123L);
        System.out.println("Concatenated as long: " + resultLong);

        // 테스트 4: 리스트에서 최소값, 최대값 찾기
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        int min = findMin(numbers);
        int max = findMax(numbers);
        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
    }
}
