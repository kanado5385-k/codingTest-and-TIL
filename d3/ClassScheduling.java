package d3;

import java.util.*;

public class ClassScheduling {
    public static void main(String[] args) {
        // 수업 시간 입력 (시작, 종료)
        int[][] classes = {
            {1, 4},
            {2, 5},
            {3, 6},
            {5, 7},
            {8, 9}
        };

        System.out.println("최대 예약 가능한 수업 수: " + maxClasses(classes));
    }

    public static int maxClasses(int[][] classes) {
        // 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(classes, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int lastEndTime = 0;

        for (int[] cls : classes) {
            int start = cls[0];
            int end = cls[1];

            // 현재 수업의 시작 시간이 이전 수업의 종료 시간 이후라면 예약 가능
            if (start >= lastEndTime) {
                count++;
                lastEndTime = end;
            }
        }

        return count;
    }
}