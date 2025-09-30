package level3;
import java.util.*;


public class simulation {

class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<Integer> myAllNumberOfCases;
    List<Integer> otherAllNumberOfCases;
    
    public int[] solution(int[][] dice) {
        List<Integer> list = new ArrayList<>();
        int len = dice.length / 2;
        int[] answer = new int[len];
        dfs(len, dice, list, 0);
        
        String mixture = "";
        int max = Integer.MIN_VALUE;
        for (String key: map.keySet()) {
            int num = map.get(key);
            if (num > max) {
                max = num;
                mixture = key;
            }
        }
        
        String[] strAnswer = mixture.split("");
        
        for (int i = 0; i < strAnswer.length; i++) {
            answer[i] = Integer.parseInt(strAnswer[i]) + 1;
        }
        
        return answer;
    }
    
    public void dfs(int len, int[][] dice, List<Integer> list, int index) {
        if (list.size() == len) {
            myAllNumberOfCases = new ArrayList<>();
            otherAllNumberOfCases = new ArrayList<>();
            getProbability(list, dice);
            return;
        }
        
        for (int i = index; i < dice.length; i++) {
            list.add(i);
            dfs(len, dice, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public void getProbability(List<Integer> list, int[][] dice) {
        List<Integer> myDice = new ArrayList<>();
        List<Integer> otherDice = new ArrayList<>();
        
        for (int i = 0; i < dice.length; i++) {
            if (list.contains(i)) {
                myDice.add(i);
                continue;
            }
            otherDice.add(i);
        }
        
        Collections.sort(myDice);
        Collections.sort(otherDice);
        
        numberOfMyCases(myDice, dice, 0, 0);
        numberOfOtherCases(otherDice, dice, 0, 0);
        
        Collections.sort(otherAllNumberOfCases);

        int win = 0;
        for (int myNum : myAllNumberOfCases) {
            int count = countSmallerThan(myNum, otherAllNumberOfCases);
            win += count;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myDice.size(); i++) {
            sb.append(myDice.get(i));
        }
        
        map.put(sb.toString(), win);
    }
    
    private int countSmallerThan(int target, List<Integer> sortedList) {
        int left = 0;
        int right = sortedList.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    
    public void numberOfMyCases(List<Integer> curDice, int[][] dice, int step, int sum) {
        if (step == curDice.size()) {
            myAllNumberOfCases.add(sum);
            return;
        }

        int diceIndex = curDice.get(step);
        for (int j = 0; j < 6; j++) {
            numberOfMyCases(curDice, dice, step + 1, sum + dice[diceIndex][j]);
        }
    }
    
    public void numberOfOtherCases(List<Integer> curDice, int[][] dice, int step, int sum) {
        if (step == curDice.size()) {
            otherAllNumberOfCases.add(sum);
            return;
        }

        int diceIndex = curDice.get(step);
        for (int j = 0; j < 6; j++) {
            numberOfOtherCases(curDice, dice, step + 1, sum + dice[diceIndex][j]);
        }
    }
}
}
