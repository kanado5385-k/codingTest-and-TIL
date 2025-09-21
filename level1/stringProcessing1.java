package level1;

public class stringProcessing1 {
    class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-zA-Z0-9_.-]", "");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        if (new_id.length() == 0) new_id = "a";
        
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^\\.|\\.$", "");
        }
        
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
            char lastChar = new_id.charAt(new_id.length() - 1);
            new_id += String.valueOf(lastChar);
            }
            
        }
        
        String answer = new_id;
        return answer;
    }
}
}
