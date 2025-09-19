package level2;

public class stringProcessing {
    class Solution {
    public int solution(int n, int k) {
        String strNumber = Integer.toString(n, k);
        
        String[] targetNumbers = strNumber.split("0+");
        
        int answer = 0;
        for (String targetNumber: targetNumbers) {
            if (targetNumber.isEmpty()) continue;
            long num = Long.parseLong(targetNumber);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        long sqrt = (long) Math.sqrt(num);
        for (long i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
}
