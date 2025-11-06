package level2;
import java.util.*;

public class stringProgressing9 {
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        String substring = s.substring(2, s.length() - 2);
        String[] split = substring.split("\\},\\{");
        List<int[]> tuple = new ArrayList<>();
        
        for (int i = 0; i < split.length; i++) {
            String curTup = split[i];
            String[] split2 = curTup.split(",");
            int[] arr = new int[split2.length];
            for (int j = 0; j < split2.length; j++) {
                arr[j] = Integer.parseInt(split2[j]);
            }
            tuple.add(arr);
        }
        
        tuple.sort(Comparator.comparingInt(arr -> arr.length));
        
        for (int[] curArr : tuple) {
            for (int num : curArr) {
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}
}
