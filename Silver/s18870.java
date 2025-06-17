import java.util.*;

public class s18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> list1 = new ArrayList<>(); // 2 4 -10 4 -9


        for (int i = 0; i < N; i++) {
            list1.add(sc.nextInt());
        }

        List<Integer> list5 = new ArrayList<>(list1); // 2 4 -10 4 -9
        Collections.sort(list1);
        Set<Integer> set = new TreeSet<>(list1); // [-10, -9, 2, 4]
        List<Integer> uniqueList = new ArrayList<>(set); // [-10, -9, 2, 4]
        Map<Integer,Integer> map = new HashMap<>();

        int inx = 0;
        for (int num : uniqueList) {
            if (!map.containsKey(num)) {
                map.put(num, inx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list5) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
