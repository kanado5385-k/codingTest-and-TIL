import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Simulation2020 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> carOrder = new HashMap<>();
        List<String> listOut = new ArrayList<>();

        // 차량의 입력 순서 저장
        for (int i = 0; i < N; i++) {
            String car = sc.nextLine().trim();
            carOrder.put(car, i);
        }

        // 차량의 출력 순서 저장
        for (int i = 0; i < N; i++) {
            listOut.add(sc.nextLine().trim());
        }

        int result = countOvertakes(carOrder, listOut);
        System.out.println(result);
        sc.close();
    }

    public static int countOvertakes(HashMap<String, Integer> carOrder, List<String> listOut){
        int overtakes = 0;
        int minPosition = Integer.MAX_VALUE;

        // 뒤에서부터 순회하며 추월한 차량 수 계산
        for (int i = listOut.size() - 1; i >= 0; i--) {
            String car = listOut.get(i);
            int position = carOrder.get(car);
            if (position > minPosition) {
                overtakes++;
            } else {
                minPosition = position;
            }
        }
        return overtakes;
    }

    //indexOf 메서드의간 복잡도가 O(N), 
    //이를 모든 차량에 대해 수행하면 전체 시간 복잡도는 O(N^2)된다.
    //HashMap을 사용하여 각 차량의 입력 순서 위치를 저장하여 위치 검색을 O(1)에 할 수 있게헤서, 전체 시간 복잡도를 O(N)으로 감소
}
