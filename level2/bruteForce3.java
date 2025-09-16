package level2;

import java.util.List;
import java.util.ArrayList;

public class bruteForce3 {

class Solution {
    static int maxPlusUsers;
    static int maxSalesAmount;
    static double[] saleRate = {0.10, 0.20, 0.30, 0.40};

    public int[] solution(int[][] users, int[] emoticons) {
        maxPlusUsers = 0;
        maxSalesAmount = 0;

        List<Double> curSaleRate = new ArrayList<>();
        dfs(users, emoticons, curSaleRate);

        return new int[]{maxPlusUsers, maxSalesAmount};
    }

    private void dfs(int[][] users, int[] emoticons, List<Double> curSaleRate) {
        if (curSaleRate.size() < emoticons.length) {
            for (int i = 0; i < 4; i++) {
                curSaleRate.add(saleRate[i]);
                dfs(users, emoticons, curSaleRate);
                curSaleRate.remove(curSaleRate.size() - 1);
            }
            return;
        }

        int[] newPriceOfEmoticons = new int[emoticons.length];
        for (int i = 0; i < curSaleRate.size(); i++) {
            int newPrice = (int)Math.round(emoticons[i] * (1 - curSaleRate.get(i)));
            newPriceOfEmoticons[i] = newPrice;
        }

        int curMaxPlusUsers = 0;
        int curMaxSalesAmount = 0;

        for (int i = 0; i < users.length; i++) {
            int minDiscountPercent = users[i][0];
            int plusPriceLimit = users[i][1];   
            double minDiscountRate = minDiscountPercent / 100.0;

            int sumOfPrice = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (curSaleRate.get(j) >= minDiscountRate) {
                    sumOfPrice += newPriceOfEmoticons[j];
                }
            }

            if (sumOfPrice >= plusPriceLimit) {
                curMaxPlusUsers++;       
            } else {
                curMaxSalesAmount += sumOfPrice; 
            }
        }

        if (curMaxPlusUsers > maxPlusUsers) {
            maxPlusUsers = curMaxPlusUsers;
            maxSalesAmount = curMaxSalesAmount;
        } else if (curMaxPlusUsers == maxPlusUsers &&
                   curMaxSalesAmount > maxSalesAmount) {
            maxSalesAmount = curMaxSalesAmount;
        }
    }
}

}
