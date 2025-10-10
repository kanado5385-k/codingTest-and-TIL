package level3;

public class tree {
    class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String binary = Long.toBinaryString(number);
            
            int needLen = getNeedLen(binary.length());
            binary = String.format("%" + needLen + "s", binary).replace(" ", "0");
            
            if (isTwoTree(binary)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        
        return answer;
    }
    
    public boolean isTwoTree(String tree) {
        if (tree.length() == 1) return true;
        int start = 0;
        int end = tree.length();
        int mid = (end + start) / 2;
        
        char root = tree.charAt(mid);
        if (root == '0') {
            for (int i = mid - 1; i >= start; i--) {
                if (tree.charAt(i) == '1') return false;
            }
            for (int i = mid + 1; i < end; i++) {
                if (tree.charAt(i) == '1') return false;
            }
        }
        
        return isTwoTree(tree.substring(start, mid)) && isTwoTree(tree.substring(mid + 1, end));
    }
    
    public int getNeedLen(int len) {
        int size = 1;
        while (size < len) {
            size = size * 2 + 1;
        }
        
        return size;
    }
}
}
