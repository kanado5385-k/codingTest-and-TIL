package level1;
import java.util.Map;
import java.util.HashMap;

public class stringProcessing3 {

class Solution {
    Map<String, Integer> nextMonthGift = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                calculateNextMonthGift(friends[i], friends[j], gifts);
            }
        }
        
        int answer = 0;
        for (String friend: nextMonthGift.keySet()) {
            int giftNum = nextMonthGift.get(friend);
            if (giftNum > answer) {
                answer = giftNum;
            }
        }
    
        return answer;
    }
    
    public void calculateNextMonthGift(String friend1, String friend2, String[] gifts) {
        String str1 = friend1 + " " + friend2;
        String str2 = friend2 + " " + friend1;
        
        int friend1To2 = 0;
        int friend2To1 = 0;
        
        for (int i = 0; i < gifts.length; i++) {
            if (str1.equals(gifts[i])) {
                friend1To2++;
            } else if (str2.equals(gifts[i])) {
                friend2To1++;
            }
        }
        
        if (friend1To2 > friend2To1) {
            nextMonthGift.put(friend1, nextMonthGift.getOrDefault(friend1, 0) + 1);
        } else if (friend2To1 > friend1To2) {
            nextMonthGift.put(friend2, nextMonthGift.getOrDefault(friend2, 0) + 1);
        } else if (friend2To1 == friend1To2) {
            int giftStaticOfFriend1 = getGiftStatic(friend1, gifts);
            int giftStaticOfFriend2 = getGiftStatic(friend2, gifts);
            if (giftStaticOfFriend1 > giftStaticOfFriend2) {
                nextMonthGift.put(friend1, nextMonthGift.getOrDefault(friend1, 0) + 1);
            } else if (giftStaticOfFriend2 > giftStaticOfFriend1) {
                nextMonthGift.put(friend2, nextMonthGift.getOrDefault(friend2, 0) + 1);
            }
        }
    }
    
    public int getGiftStatic(String friend, String[] gifts) {
        int receivedNum = 0;
        int givedNum = 0;
        
        for (int i = 0; i < gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            if (friend.equals(split[0])) {
                givedNum++;
            } else if (friend.equals(split[1])) {
                receivedNum++;
            }
        }
        
        return givedNum - receivedNum;
    }
}
}
