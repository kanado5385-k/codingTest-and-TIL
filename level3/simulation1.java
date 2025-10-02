package level3;
import java.util.List;
import java.util.ArrayList;

public class simulation1 {

class Solution {
    public int solution(int coin, int[] cards) {
        List<Integer> myCard = new ArrayList<>();
        List<Integer> candidateCard = new ArrayList<>();
        int myCoin = coin;
        int len = cards.length;
        int startCard = len / 3;
        
        for (int i = 0; i < startCard; i++) {
            myCard.add(cards[i]);
        }
        
        
        int answer = 1;
        
        for (int i = startCard; i < len - 1; i = i + 2) {
            candidateCard.add(cards[i]);
            candidateCard.add(cards[i + 1]);
            
            if (canMakeNumber(myCard, myCard, len + 1)) {
                answer++;
                continue;
            } else if (myCoin > 0 && canMakeNumber(myCard, candidateCard, len + 1)) {
                myCoin--;
                answer++;
                continue;
            } else if (myCoin > 1 && canMakeNumber(candidateCard, candidateCard, len + 1)) {
                myCoin -= 2;
                answer++;
                continue;
            } else {
                break;
            }
            
        }
        
        
        return answer;
    }
    
    public boolean canMakeNumber(List<Integer> card1, List<Integer> card2, int target) {
        List<Integer> copy1 = new ArrayList<>(card1);
        List<Integer> copy2 = new ArrayList<>(card2);

        for (int num1 : copy1) {
            for (int num2 : copy2) {
                if (card1 == card2 && num1 == num2) continue; 
                if (num1 + num2 == target) {
                    card1.remove(Integer.valueOf(num1));
                    card2.remove(Integer.valueOf(num2));
                    return true;
                }
    }
}
        return false;
    }
}
}
