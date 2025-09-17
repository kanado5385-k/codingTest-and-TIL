package level1;
import java.util.Arrays;

public class greedy {

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int j = 0; j < reserve.length; j++) {
            if (reserve[j] == -1) continue;

            for (int i = 0; i < lost.length; i++) {
                if (lost[i] == -1) continue;

                if (Math.abs(reserve[j] - lost[i]) == 1) {
                    lost[i] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}

}
