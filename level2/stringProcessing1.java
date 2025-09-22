package level2;
    import java.util.*;

public class stringProcessing1 {

class Solution {
    static Map<String, List<Integer>> searchCombi = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            String[] conditions = Arrays.copyOfRange(split, 0 ,4);
            int score = Integer.parseInt(split[4]);
            
            makeCombination(conditions, "", 0, score);
        }
        
        for (List<Integer> list : searchCombi.values()) {
            Collections.sort(list);
        }
        
        for (int i = 0; i < query.length; i++) {
            String newQuery = query[i].replace(" and ", " ");
            String[] split = newQuery.split(" ");
            newQuery = split[0] + split[1] + split[2] + split[3];
            int targetScore = Integer.parseInt(split[4]);
            
            List<Integer> scoreList = searchCombi.getOrDefault(newQuery, new ArrayList<>());
            int index = lowerBound(scoreList, targetScore);
            int people = scoreList.size() - index;
            answer.add(people);
            
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }
    
    public void makeCombination(String[] conditions, String cur, int step, int score) {
        if (step == 4) {
            searchCombi.putIfAbsent(cur, new ArrayList<>());
            searchCombi.get(cur).add(score);
            return;
        }
        
        makeCombination(conditions, cur + conditions[step], step + 1, score);
        makeCombination(conditions, cur + "-", step + 1, score);
    }
    
    public int lowerBound(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            int score = list.get(mid);
            if (score >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}
}
