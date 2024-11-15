package d3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class View1206 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = sc.nextInt();
            sc.nextLine();

            String[] buildings = sc.nextLine().split(" ");
            List<Integer> intBuildings = new ArrayList<>();
            for (String building : buildings) {
                int intBuilding = Integer.parseInt(building);
                intBuildings.add(intBuilding);
            }

            int result = 0;
            for (int i = 2; i <= N - 3; i++) {
                int currentBuilding = intBuildings.get(i);
                int leftBuilding1 = intBuildings.get(i - 1);
                int leftBuilding2 = intBuildings.get(i - 2);
                int rightBuilding1 = intBuildings.get(i + 1);
                int rightBuilding2 = intBuildings.get(i + 2);

                int maxSurrounding = Math.max(
                    Math.max(leftBuilding1, leftBuilding2),
                    Math.max(rightBuilding1, rightBuilding2)
                );

                if (currentBuilding > maxSurrounding) {
                    result += currentBuilding - maxSurrounding;
                }
            }

            System.out.println("#" + testCase + " " + result);
        }

        sc.close();
    }
}